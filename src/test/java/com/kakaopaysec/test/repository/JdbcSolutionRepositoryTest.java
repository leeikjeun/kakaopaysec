package com.kakaopaysec.test.repository;

import com.kakaopaysec.test.model.QuestionModel3and4;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Transactional
public class JdbcSolutionRepositoryTest {

    @Autowired
    private JdbcSolutionRepository solutionRepository;

    @Test
    public void getTrYearTest(){
        List<String> years = solutionRepository.getTrYears();

        String[] yearsCompareData = {"2018","2019","2020"};

        assertThat(3, is(years.size()));

        for(int i = 0; i < yearsCompareData.length; i++){
            assertThat(years.get(i), is(yearsCompareData[i]));
        }
    }

    @Test
    public void solution3Test(){
        List<QuestionModel3and4> datas = solutionRepository.solution3("2018");

        assertThat(datas.size(), is(4));
    }

    @Test
    public void solution4Test(){
        List<QuestionModel3and4> datas = solutionRepository.solution4("판교점");
        assertThat(datas.size(), is(1));
        assertThat(datas.get(0).getBrCode(), is("A"));
        assertThat(datas.get(0).getSumAmt(), is(171210000L));

        datas = solutionRepository.solution4("분당점");
        assertThat(datas.size(), is(0));
    }

}
