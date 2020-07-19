package com.kakaopaysec.test.mvcTest;

import com.kakaopaysec.test.model.QuestionModel1;
import com.kakaopaysec.test.model.QuestionModel2;
import com.kakaopaysec.test.model.QuestionModel3and4;
import com.kakaopaysec.test.service.QuestionSolutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class MvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionSolutionService service;

    @Autowired
    WebApplicationContext ctx;

    @BeforeEach
    public void setting(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8",true))
                .alwaysDo(print())
                .build();
    }

    @Test
    public void solution1Test() throws Exception {

        List<QuestionModel1> questionModel1s = new ArrayList<>();

        final QuestionModel1 questionModel1 = new QuestionModel1("3000","리릭전","02000000206",99999999999L);

        questionModel1s.add(questionModel1);

        given(service.questionModel1s()).willReturn(questionModel1s);

        final ResultActions actions = mockMvc.perform(get("/solution1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void solution2Test() throws Exception {

        List<QuestionModel2> questionModel2s = new ArrayList<>();

        final QuestionModel2 questionModel2 = new QuestionModel2("3000","분당점","02000000206");

        questionModel2s.add(questionModel2);

        given(service.questionModel2s()).willReturn(questionModel2s);

        final ResultActions actions = mockMvc.perform(get("/solution2"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void solution3Test() throws Exception {
        List<Map<String, Object>> questionModel3s = new ArrayList<>();

        final QuestionModel3and4 questionModel3 = new QuestionModel3and4("A","판교점",999999L);

        HashMap<String,Object> map = new HashMap<>();

        map.put("year","3000");
        map.put("dataList",questionModel3);

        questionModel3s.add(map);

        given(service.questionModel3s()).willReturn(questionModel3s);

        final ResultActions actions = mockMvc.perform(get("/solution3"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void solution4Test() throws Exception {
        final QuestionModel3and4 questionModel4 = new QuestionModel3and4("A","판교점",999999L);

        given(service.questionModel4("판교점")).willReturn(questionModel4);


        final ResultActions actions = mockMvc.perform(


        post("/solution4")
                        .header("Accept","application/json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(" { \"dept_nm\": \"판교점\" }")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
