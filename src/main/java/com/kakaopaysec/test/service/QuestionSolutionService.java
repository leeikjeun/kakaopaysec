package com.kakaopaysec.test.service;

import com.kakaopaysec.test.customException.BizRuntimeException;
import com.kakaopaysec.test.model.QuestionModel1;
import com.kakaopaysec.test.model.QuestionModel2;
import com.kakaopaysec.test.model.QuestionModel3and4;
import com.kakaopaysec.test.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionSolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    public List<QuestionModel1> questionModel1s(){

        List<QuestionModel1> dataOf2018 = solutionRepository.solution1("2018");
        List<QuestionModel1> dataOf2019 = solutionRepository.solution1("2019");

        ArrayList<QuestionModel1> questionModel1 = new ArrayList<>();

        if (!dataOf2018.isEmpty()) {
            questionModel1.add(dataOf2018.get(0));
        }

        if (!dataOf2019.isEmpty()) {
            questionModel1.add(dataOf2019.get(0));
        }

        return questionModel1;
    }

    public List<QuestionModel2> questionModel2s(){

        List<QuestionModel2> dataOf2018 = solutionRepository.solution2("2018");
        List<QuestionModel2> dataOf2019 = solutionRepository.solution2("2019");

        ArrayList<QuestionModel2> questionModel2 = new ArrayList<>();

        for(QuestionModel2 questionModel : dataOf2018){
            questionModel2.add(questionModel);
        }

        for(QuestionModel2 questionModel : dataOf2019){
            questionModel2.add(questionModel);
        }

        return questionModel2;
    }

    public List<Map<String, Object>> questionModel3s(){
        List<Map<String,Object>> returnData = new ArrayList<>();

        List<String> years = solutionRepository.getTrYears();

        for(String year : years){
            HashMap<String, Object> map = new HashMap<>();
            map.put("year", year);
            map.put("dataList", solutionRepository.solution3(year));

            returnData.add(map);
        }

        return returnData;
    }

    public QuestionModel3and4 questionModel4(String dept_nm){
        List<QuestionModel3and4> list = solutionRepository.solution4(dept_nm);

        if(list.size() == 0){
            throw new BizRuntimeException("404", "br cod not found error");
        }

        return list.get(0);
    }
}
