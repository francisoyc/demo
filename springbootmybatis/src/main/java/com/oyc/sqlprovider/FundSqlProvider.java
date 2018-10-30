package com.oyc.sqlprovider;

import com.oyc.bean.FundPortfolio;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class FundSqlProvider {
    public String addFundPerReportPortfolio(@Param("FundPortfolio") FundPortfolio fundPortfolio) {
        return new SQL(){{
            INSERT_INTO("fund_per_report_portfolio");
            //多个写法.
//            INTO_COLUMNS("name","email");
//            INTO_VALUES("#{name}","#{email}");

            //条件写法.
//         if(demo.getName() != null){
//            VALUES("name","#{name}");
//         }
//         if(demo.getEmail() != null){
//            VALUES("email","#{email}");
//         }

        }}.toString();
    }
}