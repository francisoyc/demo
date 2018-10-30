package com.oyc.bean;

import java.math.BigDecimal;

/**
 * 投资组合信息实体
 */
public class FundPortfolio {
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
     * 权益投资
     */
    private BigDecimal equity;
    /**
     * 权益投资比例
     */
    private BigDecimal equityProp;
    /**
     * 基金投资
     */
    private BigDecimal fund;
    /**
     * 基金投资比例
     */
    private BigDecimal fundProp;
    /**
     * 固定投资
     */
    private BigDecimal fixedIncome;
    /**
     * 固定投资比例
     */
    private BigDecimal fixedIncomeProp;
    /**
     * 贵金属投资
     */
    private BigDecimal nobleMetal;
    /**
     * 贵金属投资比例
     */
    private BigDecimal nobleMetalProp;
    /**
     * 金融衍生产品投资
     */
    private BigDecimal derivatives;
    /**
     * 金融衍生产品投资比例
     */
    private BigDecimal derivativesProp;
    /**
     * 返售式金融资产
     */
    private BigDecimal assetsResale;
    /**
     * 返售式金融资产比例
     */
    private BigDecimal assetsResaleProp;
    /**
     * 银行存款和结算备付金合计
     */
    private BigDecimal deposit;
    /**
     * 银行存款和结算备付金合计比例
     */
    private BigDecimal depositProp;
    /**
     * 其他资产
     */
    private BigDecimal other;
    /**
     * 其他资产比例
     */
    private BigDecimal otherProp;
    /**
     * 合计
     */
    private BigDecimal total;
    /**
     * 合计比例
     */
    private BigDecimal totalProp;

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

    public BigDecimal getEquity() {
        return equity;
    }

    public void setEquity(BigDecimal equity) {
        this.equity = equity;
    }

    public BigDecimal getEquityProp() {
        return equityProp;
    }

    public void setEquityProp(BigDecimal equityProp) {
        this.equityProp = equityProp;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public BigDecimal getFundProp() {
        return fundProp;
    }

    public void setFundProp(BigDecimal fundProp) {
        this.fundProp = fundProp;
    }

    public BigDecimal getFixedIncome() {
        return fixedIncome;
    }

    public void setFixedIncome(BigDecimal fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    public BigDecimal getFixedIncomeProp() {
        return fixedIncomeProp;
    }

    public void setFixedIncomeProp(BigDecimal fixedIncomeProp) {
        this.fixedIncomeProp = fixedIncomeProp;
    }

    public BigDecimal getNobleMetal() {
        return nobleMetal;
    }

    public void setNobleMetal(BigDecimal nobleMetal) {
        this.nobleMetal = nobleMetal;
    }

    public BigDecimal getNobleMetalProp() {
        return nobleMetalProp;
    }

    public void setNobleMetalProp(BigDecimal nobleMetalProp) {
        this.nobleMetalProp = nobleMetalProp;
    }

    public BigDecimal getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(BigDecimal derivatives) {
        this.derivatives = derivatives;
    }

    public BigDecimal getDerivativesProp() {
        return derivativesProp;
    }

    public void setDerivativesProp(BigDecimal derivativesProp) {
        this.derivativesProp = derivativesProp;
    }

    public BigDecimal getAssetsResale() {
        return assetsResale;
    }

    public void setAssetsResale(BigDecimal assetsResale) {
        this.assetsResale = assetsResale;
    }

    public BigDecimal getAssetsResaleProp() {
        return assetsResaleProp;
    }

    public void setAssetsResaleProp(BigDecimal assetsResaleProp) {
        this.assetsResaleProp = assetsResaleProp;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getDepositProp() {
        return depositProp;
    }

    public void setDepositProp(BigDecimal depositProp) {
        this.depositProp = depositProp;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getOtherProp() {
        return otherProp;
    }

    public void setOtherProp(BigDecimal otherProp) {
        this.otherProp = otherProp;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalProp() {
        return totalProp;
    }

    public void setTotalProp(BigDecimal totalProp) {
        this.totalProp = totalProp;
    }
}
