package com.oyc.util;

import com.oyc.bean.FundPortfolio;
import com.oyc.bean.FundPortfolioBond;
import com.oyc.bean.FundPortfolioStock;
import com.oyc.bean.FundStockTopN;
import com.oyc.service.FundPortfolioService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParseXML {

    @Autowired
    private FundPortfolioService fundPortfolioService;

    FundPortfolio fundPortfolio;
    FundPortfolioBond fundPortfolioBond;
    FundStockTopN fundStockTopN;
    FundPortfolioStock fundPortfolioStock;

    /**
     * 读取XML文件并解析
     */
    public Map<String, Object> parse(InputStream file) {
        Map<String, Object> map = null;
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();
            String fundType = ""; // 基金类型
            Element eleFundType = rootElement.element("GaiJiJinDeJiJinLeiXing"); // 获取该基金的类型
            if (null != eleFundType) {
                fundType = eleFundType.getTextTrim();
            }

            fundPortfolio = new FundPortfolio();
            fundPortfolioStock = new FundPortfolioStock();
            map = parseCurrency(rootElement);

            // 根据基金类型确定调取哪种解析方法
            /*switch(fundType) {
                case "货币型" :

                    fundPortfolioBond = new FundPortfolioBond();
                    map = parseCurrency(rootElement);
                    fundPortfolioService.addFundPortfolio(fundPortfolio);
                    break;
                case "债券型" : //parseBond(rootElement);
                    break;
                case "QDII" : //parseQDII(rootElement);
                    break;
                case "股票型" :
                    fundStockTopN = new FundStockTopN();
                    fundPortfolio = new FundPortfolio();
                    fundPortfolioStock = new FundPortfolioStock();
                    parseStock(rootElement);
                    break;
                case "混合型" : //parseMixture(rootElement);
                    break;
                default:
                    break;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


    /**
     * 解析货币类型xml的dom节点
     * @param element  待解析的节点
     */
    public Map<String, Object> parseCurrency(Element element) {
        Map<String, Object> map = new HashMap<>();
        if (null != element) {
            List<Element> eleList = element.elements();
            if (null != eleList && eleList.size() > 1) {
                for (Element ele : eleList) {
                    String nodeName = ele.getQName().getName();
                    if (nodeName.equals("JiJinJiaoYiDaiMa")) { // 基金代码
                        fundPortfolio.setFundCode(ele.getTextTrim());
                        fundPortfolioStock.setFundCode(ele.getTextTrim());
                    } else if (nodeName.equals("BaoGaoQiJianKaiShiRiQi")) { // 开始日期
                        fundPortfolio.setBeginDate(ele.getTextTrim());
                        fundPortfolioStock.setBeginDate(ele.getTextTrim());
                    } else if (nodeName.equals("BaoGaoQiJianJieShuRiQi")) { // 截止日期
                        fundPortfolio.setEndDate(ele.getTextTrim());
                        fundPortfolioStock.setEndDate(ele.getTextTrim());
                    } else if (nodeName.equals("BGQMJJZCZHQKGuDingShouYiLeiTouZi")) { // 固定收益投资
                        fundPortfolio.setFixedIncome(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKGuDingShouYiLeiTouZiZhanJiJinZongZiChanDeBiLi")) { // 固定收益投资比例
                        fundPortfolio.setFixedIncomeProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("MaiRuFanShouJinRongZiChan")) { // 买入返售金融资产
                        fundPortfolio.setAssetsResale(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKMaiRuFanShouJinRongZiChanZhanJiJinZongZiChanDeBiLi")) { // 买入返售金融资产比例
                        fundPortfolio.setAssetsResaleProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKYinHangCunKuanHeQingSuanBeiFuJin")) { // 银行存款和备付金
                        fundPortfolio.setDeposit(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKYinHangCunKuanHeQingSuanBeiFuJinZhanJiJinZongZiChanDeBiLi")) { // 银行存款和备付金比例
                        fundPortfolio.setDepositProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKQiTaZiChan")) { // 其他资产
                        fundPortfolio.setOther(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKQiTaZiChanZhanJiJinZiZongZiChanDeBiLi")) { // 其他资产比例
                        fundPortfolio.setOtherProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKHeJi")) {  // 合计
                        fundPortfolio.setTotal(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKHeJiZhanJiJinZiZongZiChanDeBiLi")) {  // 合计比例
                        fundPortfolio.setTotalProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("ANongLinMuYuYeGongYunJiaZhi")) {  // 农林牧渔业
                        fundPortfolioStock.setAgriculture(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("ANongLinMuYuYeZhanJiJinZiChanJingZhiBi")) {  // 农林牧渔业占基金资产净值比例
                        fundPortfolioStock.setAgricultureProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BCaiKuangYeGongYunJiaZhi")) {  // 采矿业
                        fundPortfolioStock.setMining(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BCaiKuangYeZhanJiJinZiChanJingZhiBi")) {  // 采矿业占基金资产净值比例
                        fundPortfolioStock.setMiningProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("CZhiZaoYeGongYunJiaZhi")) {  // 制造业
                        fundPortfolioStock.setManufacturing(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("CZhiZaoYeZhanJiJinZiChanJingZhiBi")) {  // 制造业占基金资产净值比例
                        fundPortfolioStock.setManufacturingProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("DDianLiReLiRanQiJiShuiShengChanHeGongYingYeGongYunJiaZhi")) {  // 电力、热力、燃气及水生产和供应业
                        fundPortfolioStock.setElectricPower(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("DDianLiReLiRanQiJiShuiShengChanHeGongYingYeZhanJiJinZiChanJingZhiBi")) {  // 电力、热力、燃气及水生产和供应业占基金资产净值比例
                        fundPortfolioStock.setElectricPowerProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("EJianZhuYeGongYunJiaZhi")) {  // 建筑业
                        fundPortfolioStock.setConstBusiness(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("EJianZhuYeZhanJiJinZiChanJingZhiBi")) {  // 建筑业占基金资产净值比例
                        fundPortfolioStock.setConstBusinessProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("FPiFaHeLingShouYeGongYunJiaZhi")) {  // 批发、零售业
                        fundPortfolioStock.setWholesaleRetail(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("FPiFaHeLingShouYeZhanJiJinZiChanJingZhiBi")) {  // 批发、零售业占基金资产净值比例
                        fundPortfolioStock.setWholesaleRetailProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("GJiaoTongYunShuCangChuHeYouZhengYeGongYunJiaZhi")) { // 交通运输、仓储和邮政业
                        fundPortfolioStock.setCommTrans(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHTongYeCunDanZhanJiJinZiChanJingZhiBiLi")) { // 交通运输、仓储和邮政业占基金资产净值比例
                        fundPortfolioStock.setCommTransProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("HZhuSuHeCanYinYeGongYunJiaZhi")) { // 住宿和餐饮业
                        fundPortfolioStock.setHotelCatering(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("HZhuSuHeCanYinYeZhanJiJinZiChanJingZhiBi")) { // 住宿和餐饮业占基金资产净值比例
                        fundPortfolioStock.setHotelCateringProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("IXinXiChuanShuRuanJianHeXinXiJiShuFuWuYeGongYunJiaZhi")) {  // 信息传输、软件和信息技术服务业
                        fundPortfolioStock.setIt(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("IXinXiChuanShuRuanJianHeXinXiJiShuFuWuYeZhanJiJinZiChanJingZhiBi")) {  // 信息传输、软件和信息技术服务业占基金资产净值比例
                        fundPortfolioStock.setItProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("JJinRongYeGongYunJiaZhi")) {  // 金融业
                        fundPortfolioStock.setFinance(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("JJinRongYeZhanJiJinZiChanJingZhiBi")) {  // 金融业占基金资产净值比例
                        fundPortfolioStock.setFinanceProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("KFangDiChanYeGongYunJiaZhi")) {  // 房地产业
                        fundPortfolioStock.setHousing(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("KFangDiChanYeZhanJiJinZiChanJingZhiBi")) {  // 房地产业占基金资产净值比例
                        fundPortfolioStock.setHousingProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("LZuLinHeShangWuFuWuYeGongYunJiaZhi")) {  // 租赁和商务服务业
                        fundPortfolioStock.setRental(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("LZuLinHeShangWuFuWuYeZhanJiJinZiChanJingZhiBi")) {  // 租赁和商务服务业占基金资产净值比例
                        fundPortfolioStock.setRentalProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("MKeXueYanJiuHeJiShuFuWuYeGongYunJiaZhi")) {  // 科学研究和技术服务业
                        fundPortfolioStock.setScience(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("MKeXueYanJiuHeJiShuFuWuYeZhanJiJinZiChanJingZhiBi")) {  // 科学研究和技术服务业占基金资产净值比例
                        fundPortfolioStock.setScienceProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("NShuiLiHuanJingHeGongGongSheShiGuanLiYeGongYunJiaZhi")) {  // 水利、环境和公共设施管理业
                        fundPortfolioStock.setCommunalFacilities(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("NShuiLiHuanJingHeGongGongSheShiGuanLiYeZhanJiJinZiChanJingZhiBi")) {  // 水利、环境和公共设施管理业占基金资产净值比例
                        fundPortfolioStock.setCommunalFacilitiesProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("OJuMinFuWuXiuLiHeQiTaFuWuYeGongYunJiaZhi")) { // 民服务、修理和其他服务业
                        fundPortfolioStock.setResidentService(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("OJuMinFuWuXiuLiHeQiTaFuWuYeZhanJiJinZiChanJingZhiBi")) { // 民服务、修理和其他服务业占基金资产净值比例
                        fundPortfolioStock.setResidentServiceProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("PJiaoYuGongYunJiaZhi")) { // 教育
                        fundPortfolioStock.setEducation(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("PJiaoYuZhanJiJinZiChanJingZhiBi")) { // 教育占基金资产净值比例
                        fundPortfolioStock.setEducationProp(string2bigdecimal(ele.getTextTrim()));
                    }else if (nodeName.equals("QWeiShengHeSheHuiGongZuoGongYunJiaZhi")) {  // 卫生和社会工作
                        fundPortfolioStock.setHealth(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("QWeiShengHeSheHuiGongZuoZhanJiJinZiChanJingZhiBi")) {  // 卫生和社会工作占基金资产净值比例
                        fundPortfolioStock.setHealthProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("RWenHuaTiYuHeYuLeYeGongYunJiaZhi")) {  // 文化、体育和娱乐业
                        fundPortfolioStock.setEntertainment(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("RWenHuaTiYuHeYuLeYeZhanJiJinZiChanJingZhiBi")) {  // 文化、体育和娱乐业占基金资产净值比例
                        fundPortfolioStock.setEntertainmentProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("SZongHeGongYunJiaZhi")) {  // 综合
                        fundPortfolioStock.setComprehensive(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("SZongHeZhanJiJinZiChanJingZhiBi")) {  // 综合占基金资产净值比例
                        fundPortfolioStock.setComprehensiveProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("GuPiaoGongYunJiaZhiHeJi")) {  // 合计
                        fundPortfolioStock.setTotal(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("GuPiaoShiZhiHeJiZhanJiJinZiChanJingZhiBi")) {  // 合计占基金资产净值比例
                        fundPortfolioStock.setTotalProp(string2bigdecimal(ele.getTextTrim()));
                    }
                    parseCurrency(ele); // 递归解析
                }
            }
            map.put("fundPortfolio", fundPortfolio);
        }
        return map;
    }

    /**
     * 解析股票类型xml的dom节点
     * @param element  待解析的节点
     */
    public void parseStock(Element element) {
        if (null != element) {
            List<Element> eleList = element.elements();
            if (null != eleList && eleList.size() > 1) {
                for (Element ele : eleList) {
                    String nodeName = ele.getQName().getName();
                    if (nodeName.equals("JiJinJiaoYiDaiMa")) { // 基金代码
                        fundPortfolio.setFundCode(ele.getTextTrim());
                        fundPortfolioBond.setFundCode(ele.getTextTrim());
                    } else if (nodeName.equals("BaoGaoQiJianKaiShiRiQi")) { // 开始日期
                        fundPortfolio.setBeginDate(ele.getTextTrim());
                        fundPortfolioBond.setBeginDate(ele.getTextTrim());
                    } else if (nodeName.equals("BaoGaoQiJianJieShuRiQi")) { // 截止日期
                        fundPortfolio.setEndDate(ele.getTextTrim());
                        fundPortfolioBond.setEndDate(ele.getTextTrim());
                    } else if (nodeName.equals("BGQMJJZCZHQKQuanYiLeiTouZi")) { // 权益类投资
                        fundPortfolio.setEquity(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKQuanYiLeiTouZiZhanJiJinZongZiChanDeBiLi")) { // 权益类投资比例
                        fundPortfolio.setEquityProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKJiJinTouZi")) { // 基金投资
                        fundPortfolio.setFund(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKJiJinTouZiZhanJiJinZongZiChanDeBiLi")) { // 基金投资比例
                        fundPortfolio.setFundProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKGuDingShouYiLeiTouZi")) { // 固定收益投资
                        fundPortfolio.setFixedIncome(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKGuDingShouYiLeiTouZiZhanJiJinZongZiChanDeBiLi")) { // 固定收益投资比例
                        fundPortfolio.setFixedIncomeProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKGuiJinShuTouZi")) { // 贵金属投资
                        fundPortfolio.setNobleMetal(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKGuiJinShuTouZiZhanJiJinZongZiChanDeBiLi")) { // 贵金属投资比例
                        fundPortfolio.setNobleMetalProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKJinRongYanShengPinTouZi")) { // 金融衍生品投资
                        fundPortfolio.setDerivatives(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKJinRongYanShengPinTouZiZhanJiJinZongZiChanDeBiLi")) { // 金融衍生品投资比例
                        fundPortfolio.setDerivativesProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("MaiRuFanShouJinRongZiChan")) { // 买入返售金融资产
                        fundPortfolio.setAssetsResale(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKMaiRuFanShouJinRongZiChanZhanJiJinZongZiChanDeBiLi")) { // 买入返售金融资产比例
                        fundPortfolio.setAssetsResaleProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKYinHangCunKuanHeQingSuanBeiFuJin")) { // 银行存款和备付金
                        fundPortfolio.setDeposit(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKYinHangCunKuanHeQingSuanBeiFuJinZhanJiJinZongZiChanDeBiLi")) { // 银行存款和备付金比例
                        fundPortfolio.setDepositProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKQiTaZiChan")) { // 其他资产
                        fundPortfolio.setOther(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKQiTaZiChanZhanJiJinZiZongZiChanDeBiLi")) { // 其他资产比例
                        fundPortfolio.setOtherProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKHeJi")) {  // 合计
                        fundPortfolio.setTotal(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMJJZCZHQKHeJiZhanJiJinZiZongZiChanDeBiLi")) {  // 合计比例
                        fundPortfolio.setTotalProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHGuoJiaZhaiQuan")) {  // 国家债券
                        fundPortfolioBond.setNationalBond(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHGuoJiaZhaiQuanZhanJiJinZiChanJingZhiBiLi")) {  // 国家债券比例
                        fundPortfolioBond.setNationalBondProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHYangXingPiaoJu")) {  // 央行票据
                        fundPortfolioBond.setFinancialBond(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHYangXingPiaoJuZhanJiJinZiChanJingZhiBiLi")) {  // 央行票据比例
                        fundPortfolioBond.setFinancialBond(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHJinRongZhaiQuan")) {  // 金融债券
                        fundPortfolioBond.setFinancialBond(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHJinRongZhaiQuanZhanJiJinZiChanJingZhiBiLi")) {  // 金融债券比例
                        fundPortfolioBond.setFinancialBondProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiYeZhaiQuan")) {  // 企业债券
                        fundPortfolioBond.setCorpBond(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiYeZhaiQuanZhanJiJinZiChanJingZhiBiLi")) {  // 企业债券比例
                        fundPortfolioBond.setCorpBondProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiYeDuanQiRongZiQuan")) {  // 企业短期融资券
                        fundPortfolioBond.setShortTermFinBill(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiYeDuanQiRongZiQuanZhanJiJinZiChanJingZhiBiLi")) {  // 企业短期融资券比例
                        fundPortfolioBond.setShortTermFinBillProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHZhongQiPiaoJu")) {  // 中期票据
                        fundPortfolioBond.setMediumTermNote(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHZhongQiPiaoJuZhanJiJinZiChanJingZhiBiLi")) {  // 中期票据比例
                        fundPortfolioBond.setMediumTermNoteProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHTongYeCunDan")) { // 同业存单
                        fundPortfolioBond.setNcds(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHTongYeCunDanZhanJiJinZiChanJingZhiBiLi")) { // 同业存单比例
                        fundPortfolioBond.setNcdsProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiTa")) { // 其他
                        fundPortfolioBond.setOther(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHQiTaZhanJiJinZiChanJingZhiBiLi")) { // 其他比例
                        fundPortfolioBond.setOtherProp(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHHeJi")) {  // 合计
                        fundPortfolioBond.setTotal(string2bigdecimal(ele.getTextTrim()));
                    } else if (nodeName.equals("BGQMAQZFLDZQTZZHHeJiZhanJiJinZiChanJingZhiBiLi")) {  // 合计比例
                        fundPortfolioBond.setTotalProp(string2bigdecimal(ele.getTextTrim()));
                    }
                    parseStock(ele); // 递归解析
                }
            }
        }
    }
    /**
     * 将string类型转化为bigdecimal类型
     * @param s 待转化的string
     * @return
     */
    public BigDecimal string2bigdecimal(String s) {
        try {
            BigDecimal val = new BigDecimal(s);
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            return new BigDecimal(0);
        }
    }

    /**
     * 将string类型转化为bigdecimal类型，乘以100后保留两位小数点返回
     * @param s
     * @return 待转化的string
     */
    public BigDecimal str2bigmultiply100(String s) {
        try {
            BigDecimal val = new BigDecimal(s).multiply(new BigDecimal(100)).setScale(2);
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            return new BigDecimal(0);
        }
    }

   /* public static void main(String[] args) {
        new ParseXML().parse();
    }*/

   @Test
   public void test() {
    //   parse(new File("D:/test.xml"));
       //FundPortfolio f = fundPortfolioService.getInfoByFundCode("000569");
     //  System.out.println(">>>>>>>>>>>>>>>>>>>" + f.getFixedIncomeProp() + "<>" + f.getTotalProp());
     //  System.out.println(">>>>>>>>>>>>>>>>>>>" + string2bigdecimal("1.0000"));
   }
}
