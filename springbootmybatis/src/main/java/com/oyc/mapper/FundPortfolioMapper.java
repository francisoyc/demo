package com.oyc.mapper;

import com.oyc.bean.FundPortfolio;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FundPortfolioMapper {
    @Insert("insert into fund_per_report_portfolio(fund_code, begin_date, end_date, fixed_income, fixed_income_prop, assets_resale, assets_resale_prop, deposit, deposit_prop, other, other_prop, total, total_prop) " +
            "values(#{fundCode}, #{beginDate}, #{endDate}, #{fixedIncome}, #{fixedIncomeProp}, #{assetsResale}, #{assetsResaleProp}, #{deposit}, #{depositProp}, #{other}, #{otherProp}, #{total}, #{totalProp})")
    public void addFundPerReportPortfolio(FundPortfolio fundPortfolio);

    @Select("select * from fund_per_report_portfolio where fund_code = #{fundCode}")
    public FundPortfolio getInfoByFundCode(String fundCode);
}
