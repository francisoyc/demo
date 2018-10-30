package com.oyc.service;

import com.oyc.bean.FundPortfolio;

public interface FundPortfolioService {

    public void addFundPortfolio(FundPortfolio fundPortfolio);

    public FundPortfolio getInfoByFundCode(String fundCode);
}