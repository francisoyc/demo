package com.oyc.bean;

import java.math.BigDecimal;

/**
 * 报告期末按行业分类的境内股票投资组合(按公允价)
 */
public class FundPortfolioStock {

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
     * A农林牧渔业
     */
    private BigDecimal agriculture;
    /**
     * A农林牧渔业占基金资产净值比例
     */
    private BigDecimal agricultureProp;
    /**
     * B采矿业
     */
    private BigDecimal mining;
    /**
     * B采矿业占基金资产净值比例
     */
    private BigDecimal miningProp;
    /**
     * C制造业
     */
    private BigDecimal manufacturing;
    /**
     * C制造业占基金资产净值比例
     */
    private BigDecimal manufacturingProp;
    /**
     * D电力、热力、燃气及水生产和供应业
     */
    private BigDecimal electricPower;
    /**
     * D电力、热力、燃气及水生产和供应业占基金资产净值比例
     */
    private BigDecimal electricPowerProp;
    /**
     * E建筑业
     */
    private BigDecimal constBusiness;
    /**
     * E建筑业占基金资产净值比例
     */
    private BigDecimal constBusinessProp;
    /**
     * F批发、零售业
     */
    private BigDecimal wholesaleRetail;
    /**
     * F批发、零售业占基金资产净值比例
     */
    private BigDecimal wholesaleRetailProp;
    /**
     * G交通运输、仓储和邮政业
     */
    private BigDecimal commTrans;
    /**
     * G交通运输、仓储和邮政业占基金资产净值比例
     */
    private BigDecimal commTransProp;
    /**
     * H住宿和餐饮业
     */
    private BigDecimal hotelCatering;
    /**
     * H住宿和餐饮业占基金资产净值比例
     */
    private BigDecimal hotelCateringProp;
    /**
     * I信息传输、软件和信息技术服务业
     */
    private BigDecimal it;
    /**
     * I信息传输、软件和信息技术服务业占基金资产净值比例
     */
    private BigDecimal itProp;
    /**
     * J金融业
     */
    private BigDecimal finance;
    /**
     * J金融业占基金资产净值比例
     */
    private BigDecimal financeProp;
    /**
     * K房地产业
     */
    private BigDecimal housing;
    /**
     * K房地产业占基金资产净值比例
     */
    private BigDecimal housingProp;
    /**
     * L租赁和商务服务业
     */
    private BigDecimal rental;
    /**
     * L租赁和商务服务业占基金资产净值比例
     */
    private BigDecimal rentalProp;
    /**
     * M科学研究和技术服务业
     */
    private BigDecimal science;
    /**
     * M科学研究和技术服务业占基金资产净值比例
     */
    private BigDecimal scienceProp;
    /**
     * N水利、环境和公共设施管理业
     */
    private BigDecimal communalFacilities;
    /**
     * N水利、环境和公共设施管理业占基金资产净值比例
     */
    private BigDecimal communalFacilitiesProp;
    /**
     * O居民服务、修理和其他服务业
     */
    private BigDecimal residentService;
    /**
     * O民服务、修理和其他服务业占基金资产净值比例
     */
    private BigDecimal residentServiceProp;
    /**
     * P教育
     */
    private BigDecimal education;
    /**
     * P教育占基金资产净值比例
     */
    private BigDecimal educationProp;
    /**
     * Q卫生和社会工作
     */
    private BigDecimal health;
    /**
     * Q卫生和社会工作占基金资产净值比例
     */
    private BigDecimal healthProp;
    /**
     * R文化、体育和娱乐业
     */
    private BigDecimal entertainment;
    /**
     * R文化、体育和娱乐业占基金资产净值比例
     */
    private BigDecimal entertainmentProp;
    /**
     * S综合
     */
    private BigDecimal comprehensive;
    /**
     * S综合占基金资产净值比例
     */
    private BigDecimal comprehensiveProp;
    /**
     * 合计
     */
    private BigDecimal total;
    /**
     * 合计占基金资产净值比例
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

    public BigDecimal getAgriculture() {
        return agriculture;
    }

    public void setAgriculture(BigDecimal agriculture) {
        this.agriculture = agriculture;
    }

    public BigDecimal getAgricultureProp() {
        return agricultureProp;
    }

    public void setAgricultureProp(BigDecimal agricultureProp) {
        this.agricultureProp = agricultureProp;
    }

    public BigDecimal getMining() {
        return mining;
    }

    public void setMining(BigDecimal mining) {
        this.mining = mining;
    }

    public BigDecimal getMiningProp() {
        return miningProp;
    }

    public void setMiningProp(BigDecimal miningProp) {
        this.miningProp = miningProp;
    }

    public BigDecimal getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(BigDecimal manufacturing) {
        this.manufacturing = manufacturing;
    }

    public BigDecimal getManufacturingProp() {
        return manufacturingProp;
    }

    public void setManufacturingProp(BigDecimal manufacturingProp) {
        this.manufacturingProp = manufacturingProp;
    }

    public BigDecimal getElectricPower() {
        return electricPower;
    }

    public void setElectricPower(BigDecimal electricPower) {
        this.electricPower = electricPower;
    }

    public BigDecimal getElectricPowerProp() {
        return electricPowerProp;
    }

    public void setElectricPowerProp(BigDecimal electricPowerProp) {
        this.electricPowerProp = electricPowerProp;
    }

    public BigDecimal getConstBusiness() {
        return constBusiness;
    }

    public void setConstBusiness(BigDecimal constBusiness) {
        this.constBusiness = constBusiness;
    }

    public BigDecimal getConstBusinessProp() {
        return constBusinessProp;
    }

    public void setConstBusinessProp(BigDecimal constBusinessProp) {
        this.constBusinessProp = constBusinessProp;
    }

    public BigDecimal getWholesaleRetail() {
        return wholesaleRetail;
    }

    public void setWholesaleRetail(BigDecimal wholesaleRetail) {
        this.wholesaleRetail = wholesaleRetail;
    }

    public BigDecimal getWholesaleRetailProp() {
        return wholesaleRetailProp;
    }

    public void setWholesaleRetailProp(BigDecimal wholesaleRetailProp) {
        this.wholesaleRetailProp = wholesaleRetailProp;
    }

    public BigDecimal getCommTrans() {
        return commTrans;
    }

    public void setCommTrans(BigDecimal commTrans) {
        this.commTrans = commTrans;
    }

    public BigDecimal getCommTransProp() {
        return commTransProp;
    }

    public void setCommTransProp(BigDecimal commTransProp) {
        this.commTransProp = commTransProp;
    }

    public BigDecimal getHotelCatering() {
        return hotelCatering;
    }

    public void setHotelCatering(BigDecimal hotelCatering) {
        this.hotelCatering = hotelCatering;
    }

    public BigDecimal getHotelCateringProp() {
        return hotelCateringProp;
    }

    public void setHotelCateringProp(BigDecimal hotelCateringProp) {
        this.hotelCateringProp = hotelCateringProp;
    }

    public BigDecimal getIt() {
        return it;
    }

    public void setIt(BigDecimal it) {
        this.it = it;
    }

    public BigDecimal getItProp() {
        return itProp;
    }

    public void setItProp(BigDecimal itProp) {
        this.itProp = itProp;
    }

    public BigDecimal getFinance() {
        return finance;
    }

    public void setFinance(BigDecimal finance) {
        this.finance = finance;
    }

    public BigDecimal getFinanceProp() {
        return financeProp;
    }

    public void setFinanceProp(BigDecimal financeProp) {
        this.financeProp = financeProp;
    }

    public BigDecimal getHousing() {
        return housing;
    }

    public void setHousing(BigDecimal housing) {
        this.housing = housing;
    }

    public BigDecimal getHousingProp() {
        return housingProp;
    }

    public void setHousingProp(BigDecimal housingProp) {
        this.housingProp = housingProp;
    }

    public BigDecimal getRental() {
        return rental;
    }

    public void setRental(BigDecimal rental) {
        this.rental = rental;
    }

    public BigDecimal getRentalProp() {
        return rentalProp;
    }

    public void setRentalProp(BigDecimal rentalProp) {
        this.rentalProp = rentalProp;
    }

    public BigDecimal getScience() {
        return science;
    }

    public void setScience(BigDecimal science) {
        this.science = science;
    }

    public BigDecimal getScienceProp() {
        return scienceProp;
    }

    public void setScienceProp(BigDecimal scienceProp) {
        this.scienceProp = scienceProp;
    }

    public BigDecimal getCommunalFacilities() {
        return communalFacilities;
    }

    public void setCommunalFacilities(BigDecimal communalFacilities) {
        this.communalFacilities = communalFacilities;
    }

    public BigDecimal getCommunalFacilitiesProp() {
        return communalFacilitiesProp;
    }

    public void setCommunalFacilitiesProp(BigDecimal communalFacilitiesProp) {
        this.communalFacilitiesProp = communalFacilitiesProp;
    }

    public BigDecimal getResidentService() {
        return residentService;
    }

    public void setResidentService(BigDecimal residentService) {
        this.residentService = residentService;
    }

    public BigDecimal getResidentServiceProp() {
        return residentServiceProp;
    }

    public void setResidentServiceProp(BigDecimal residentServiceProp) {
        this.residentServiceProp = residentServiceProp;
    }

    public BigDecimal getEducation() {
        return education;
    }

    public void setEducation(BigDecimal education) {
        this.education = education;
    }

    public BigDecimal getEducationProp() {
        return educationProp;
    }

    public void setEducationProp(BigDecimal educationProp) {
        this.educationProp = educationProp;
    }

    public BigDecimal getHealth() {
        return health;
    }

    public void setHealth(BigDecimal health) {
        this.health = health;
    }

    public BigDecimal getHealthProp() {
        return healthProp;
    }

    public void setHealthProp(BigDecimal healthProp) {
        this.healthProp = healthProp;
    }

    public BigDecimal getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(BigDecimal entertainment) {
        this.entertainment = entertainment;
    }

    public BigDecimal getEntertainmentProp() {
        return entertainmentProp;
    }

    public void setEntertainmentProp(BigDecimal entertainmentProp) {
        this.entertainmentProp = entertainmentProp;
    }

    public BigDecimal getComprehensive() {
        return comprehensive;
    }

    public void setComprehensive(BigDecimal comprehensive) {
        this.comprehensive = comprehensive;
    }

    public BigDecimal getComprehensiveProp() {
        return comprehensiveProp;
    }

    public void setComprehensiveProp(BigDecimal comprehensiveProp) {
        this.comprehensiveProp = comprehensiveProp;
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