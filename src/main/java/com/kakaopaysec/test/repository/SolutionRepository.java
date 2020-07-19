package com.kakaopaysec.test.repository;

import com.kakaopaysec.test.model.QuestionModel1;
import com.kakaopaysec.test.model.QuestionModel2;
import com.kakaopaysec.test.model.QuestionModel3and4;

import java.util.List;

public interface SolutionRepository {

    public List<QuestionModel1> solution1(String year);

    public List<QuestionModel2> solution2(String year);

    public List<QuestionModel3and4> solution3(String year);

    public List<String> getTrYears();

    public List<QuestionModel3and4> solution4(String dept_nm);
}
