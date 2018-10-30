package com.oyc.bean;

import java.math.BigDecimal;

/**
 * 报告期末按债券品种分类的债券投资组合实体
 */
public class FundPortfolioBond {
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
     * 国家债券
     */
    private BigDecimal nationalBond;
    /**
     * 国家债券占基金资产净值比例
     */
    private BigDecimal nationalBondProp;
    /**
     * 央行票据
     */
    private BigDecimal cenBtankBill;
    /**
     * 央行票据占基金资产净值比例
     */
    private BigDecimal cenBtankBillProp;
    /**
     * 金融债券
     */
    private BigDecimal financialBond;
    /**
     * 金融债券占基金资产净值比例
     */
    private BigDecimal financialBondProp;
    /**
     * 企业债券
     */
    private BigDecimal corpBond;
    /**
     * 企业债券占基金资产净值比例
     */
    private BigDecimal corpBondProp;
    /**
     * 企业短期融资券
     */
    private BigDecimal shortTermFinBill;
    /**
     * 企业短期融资券占基金资产净值比例
     */
    private BigDecimal shortTermFinBillProp;
    /**
     * 中期票据
     */
    private BigDecimal mediumTermNote;
    /**
     * 中期票据占基金资产净值比例
     */
    private BigDecimal mediumTermNoteProp;
    /**
     * 可转债
     */
    private BigDecimal convertibleond;
    /**
     * 可转债占基金资产净值比例
     */
    private BigDecimal convertibleBondProp;
    /**
     * 同业存单
     */
    private BigDecimal ncds;
    /**
     * 同业存单占基金资产净值比例
     */
    private BigDecimal ncdsProp;
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

    public BigDecimal getNationalBond() {
        return nationalBond;
    }

    public void setNationalBond(BigDecimal nationalBond) {
        this.nationalBond = nationalBond;
    }

    public BigDecimal getNationalBondProp() {
        return nationalBondProp;
    }

    public void setNationalBondProp(BigDecimal nationalBondProp) {
        this.nationalBondProp = nationalBondProp;
    }

    public BigDecimal getCenBtankBill() {
        return cenBtankBill;
    }

    public void setCenBtankBill(BigDecimal cenBtankBill) {
        this.cenBtankBill = cenBtankBill;
    }

    public BigDecimal getCenBtankBillProp() {
        return cenBtankBillProp;
    }

    public void setCenBtankBillProp(BigDecimal cenBtankBillProp) {
        this.cenBtankBillProp = cenBtankBillProp;
    }

    public BigDecimal getFinancialBond() {
        return financialBond;
    }

    public void setFinancialBond(BigDecimal financialBond) {
        this.financialBond = financialBond;
    }

    public BigDecimal getFinancialBondProp() {
        return financialBondProp;
    }

    public void setFinancialBondProp(BigDecimal financialBondProp) {
        this.financialBondProp = financialBondProp;
    }

    public BigDecimal getCorpBond() {
        return corpBond;
    }

    public void setCorpBond(BigDecimal corpBond) {
        this.corpBond = corpBond;
    }

    public BigDecimal getCorpBondProp() {
        return corpBondProp;
    }

    public void setCorpBondProp(BigDecimal corpBondProp) {
        this.corpBondProp = corpBondProp;
    }

    public BigDecimal getShortTermFinBill() {
        return shortTermFinBill;
    }

    public void setShortTermFinBill(BigDecimal shortTermFinBill) {
        this.shortTermFinBill = shortTermFinBill;
    }

    public BigDecimal getShortTermFinBillProp() {
        return shortTermFinBillProp;
    }

    public void setShortTermFinBillProp(BigDecimal shortTermFinBillProp) {
        this.shortTermFinBillProp = shortTermFinBillProp;
    }

    public BigDecimal getMediumTermNote() {
        return mediumTermNote;
    }

    public void setMediumTermNote(BigDecimal mediumTermNote) {
        this.mediumTermNote = mediumTermNote;
    }

    public BigDecimal getMediumTermNoteProp() {
        return mediumTermNoteProp;
    }

    public void setMediumTermNoteProp(BigDecimal mediumTermNoteProp) {
        this.mediumTermNoteProp = mediumTermNoteProp;
    }

    public BigDecimal getConvertibleond() {
        return convertibleond;
    }

    public void setConvertibleond(BigDecimal convertibleond) {
        this.convertibleond = convertibleond;
    }

    public BigDecimal getConvertibleBondProp() {
        return convertibleBondProp;
    }

    public void setConvertibleBondProp(BigDecimal convertibleBondProp) {
        this.convertibleBondProp = convertibleBondProp;
    }

    public BigDecimal getNcds() {
        return ncds;
    }

    public void setNcds(BigDecimal ncds) {
        this.ncds = ncds;
    }

    public BigDecimal getNcdsProp() {
        return ncdsProp;
    }

    public void setNcdsProp(BigDecimal ncdsProp) {
        this.ncdsProp = ncdsProp;
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
