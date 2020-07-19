package com.kakaopaysec.test.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class QuestionModel1 {

    private String year;
    private String name;
    private String acctNo;
    private long sumAmt;
}
