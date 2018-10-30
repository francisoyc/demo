package com.oyc.bean;

import java.math.BigDecimal;

/**
 * 报告期末按公允价值排序的topN表实体
 */
public class FundStockTopN {
    /**
     * 基金代码
     */
    private String fundCode;
    /**
     * 定期报告类型 01-季度报告，02-半年报告，03-年度报告
     */
    private String reportType;
    /**
     *开始日期
     */
    private String beginDate;
    /**
     * 截止日期
     */
    private String endDate;
    /**
     * 证券类型 01-债券，02-境内股票
     */
    private String stockType;
    /**
     * 证券代码
     */
    private BigDecimal stockCode;
    /**
     * 证券名称
     */
    private String stockName;
    /**
     * 证券数量
     */
    private BigDecimal amount;
    /**
     * 公允价值
     */
    private BigDecimal fairValue;
    /**
     * 占基金净值比例
     */
    private BigDecimal proportion;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public BigDecimal getStockCode() {
        return stockCode;
    }

    public void setStockCode(BigDecimal stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFairValue() {
        return fairValue;
    }

    public void setFairValue(BigDecimal fairValue) {
        this.fairValue = fairValue;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }
}
