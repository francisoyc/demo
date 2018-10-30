package com.oyc.service.impl;

import com.oyc.bean.FundPortfolio;
import com.oyc.mapper.FundPortfolioMapper;
import com.oyc.service.FundPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fundPortfolioService")
//@Transactional
public class FundPortfolioServiceImpl implements FundPortfolioService {

    @Autowired
    private FundPortfolioMapper fundPortfolioMapper;

    @Override
    public void addFundPortfolio(FundPortfolio fundPortfolio) {
        fundPortfolioMapper.addFundPerReportPortfolio(fundPortfolio);
    }

    @Override
    public FundPortfolio getInfoByFundCode(String fundCode) {
        return fundPortfolioMapper.getInfoByFundCode(fundCode);
    }
}
