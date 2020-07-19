package com.kakaopaysec.test.repository;

import com.kakaopaysec.test.model.QuestionModel1;
import com.kakaopaysec.test.model.QuestionModel2;
import com.kakaopaysec.test.model.QuestionModel3and4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcSolutionRepository implements SolutionRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<QuestionModel1> solution1(String year){
        return jdbcTemplate.query(
                "select  a.acno" +
                        "  , left(a.tr_dt,4) year" +
                        "  , (select ac_nm from account where acno = a.acno) as ac_nm" +
                        "  , sum(a.tr_da) - sum(a.tr_fee) as sum_amt" +
                        "   from tr_history a" +
                        "  where a.tr_dt like ?" +
                        "    and a.tr_crcl_yn = 'N'" +
                        "  group by a.acno, year" +
                        "  order by sum_amt desc",
                new Object[]{year + "%"},
                (rs, rowNum) ->
                        new QuestionModel1(
                                rs.getString("year"),
                                rs.getString("ac_nm"),
                                rs.getString("acno"),
                                rs.getLong("sum_amt")
                        )
        );
    }

    @Override
    public List<QuestionModel2> solution2(String year){
        return jdbcTemplate.query(
                "select  a.acno" +
                        "  , left(a.tr_dt,4) year" +
                        "  , (select ac_nm from account where acno = a.acno) as ac_nm" +
                        "   from tr_history a" +
                        "  where a.tr_dt like ?" +
                        "    and a.tr_crcl_yn = 'N'" +
                        "  group by a.acno, year",
                new Object[]{year + "%"},
                (rs, rowNum) ->
                        new QuestionModel2(
                                rs.getString("year"),
                                rs.getString("ac_nm"),
                                rs.getString("acno")
                        )
        );
    }

    @Override
    public List<QuestionModel3and4> solution3(String year) {
        return jdbcTemplate.query(
                "select c.dept_cod" +
                        " , c.dept_nm" +
                        " , sum(b.tr_da) as sum_amt" +
                        "        from " +
                        "     account a" +
                        ", tr_history b" +
                        ",       dept c" +
                        "       where a.acno = b.acno" +
                        "         and a.dept_cod = c.dept_cod" +
                        "         and b.tr_crcl_yn = 'N'" +
                        "         and b.tr_dt LIKE ?" +
                        "       group by c.dept_cod, c.dept_nm" +
                        "       order by sum_amt desc",
                new Object[]{year + "%"},
                (rs, rowNum) ->
                        new QuestionModel3and4(
                                rs.getString("dept_cod"),
                                rs.getString("dept_nm"),
                                rs.getLong("sum_amt")
                        )
        );
    }

    @Override
    public List<String> getTrYears() {
        return jdbcTemplate.queryForList("select left(tr_dt,4) year" +
                " from tr_history" +
                " group by year", String.class);
    }

    @Override
    public List<QuestionModel3and4> solution4(String dept_nm) {
        return jdbcTemplate.query(
                "select a.dept_cod" +
                        "       , a.dept_nm" +
                        "       , sum(b.tr_da) as sum_amt" +
                        "   from" +
                        "  (select (case c.dept_cod when 'B' then 'A'" +
                        "                          else c.dept_cod end) as dept_cod" +
                        "       , (case c.dept_nm when '분당점' then '판교점'" +
                        "                          else c.dept_nm end) as dept_nm" +
                        "       , d.acno" +
                        " from dept c" +
                        "       , account d" +
                        " where c.dept_cod = d.dept_cod) a" +
                        "       , tr_history b" +
                        " where a.acno = b.acno" +
                        " and b.tr_crcl_yn = 'N'" +
                        " and a.dept_nm = ? " +
                        " group by a.dept_cod, a.dept_nm",
                new Object[]{dept_nm},
                (rs, rowNum) ->
                        new QuestionModel3and4(
                                rs.getString("dept_cod"),
                                rs.getString("dept_nm"),
                                rs.getLong("sum_amt")
                        )
        );
    }


}
