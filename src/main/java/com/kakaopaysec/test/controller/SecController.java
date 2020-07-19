package com.kakaopaysec.test.controller;

import com.kakaopaysec.test.customException.BizRuntimeException;
import com.kakaopaysec.test.model.QuestionModel1;
import com.kakaopaysec.test.model.QuestionModel2;
import com.kakaopaysec.test.model.QuestionModel3and4;
import com.kakaopaysec.test.service.QuestionSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SecController {

    @Autowired
    QuestionSolutionService service;

    @GetMapping(value = "/solution1")
    @ResponseBody
    public List<QuestionModel1> solution1(){
        return service.questionModel1s();
    }

    @GetMapping(value = "/solution2")
    @ResponseBody
    public List<QuestionModel2> solution2(){
        return service.questionModel2s();
    }

    @GetMapping(value = "/solution3")
    @ResponseBody
    public List solution3(){
        return service.questionModel3s();
    }

    @GetMapping(value = "/solution4")
    @ResponseBody
    public QuestionModel3and4 solution4(@RequestParam String dept_nm){
        return service.questionModel4(dept_nm);
    }

    @ExceptionHandler(BizRuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handle(BizRuntimeException e) {
        Map<String, String> errorAttributes = new HashMap<>();

        errorAttributes.put("code", e.getCode());
        errorAttributes.put("메시지", e.getMessage());

        return errorAttributes;
    }

}
