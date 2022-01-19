package AndroidUI.POM.PaymentsApp;

import AndroidUI.Base.BaseUtilsUI;
import CommonBase.CommonUtils;
import Constants.Paths;

import java.util.Properties;

public class PaymentsAmazonPayValidationsPage extends BaseUtilsUI {

    static PaymentsAmazonPayValidationsPage paymentsAmazonPayValidationsPage;
    static Properties commonLocatorsProperties;
    static Properties paymentsAmazonPayProperties;

    private PaymentsAmazonPayValidationsPage() {

        commonLocatorsProperties = CommonUtils.readPropertyfile(Paths.commonLocPropertiesPath);
        paymentsAmazonPayProperties = CommonUtils.readPropertyfile(Paths.amazonPayPropertiesPath);

    }

    public static PaymentsAmazonPayValidationsPage getInstance() {
        if (paymentsAmazonPayValidationsPage == null)
            paymentsAmazonPayValidationsPage = new PaymentsAmazonPayValidationsPage();
        return paymentsAmazonPayValidationsPage;
    }

    public void selectAmazonPaySale() {

        clickOnElement(paymentsAmazonPayProperties.getProperty("amazonPaySale"));
    }

    public void selectPaymentMode(String payMode) {
        clickOnElement(commonLocatorsProperties.getProperty("searchButton"));
        setElementText(commonLocatorsProperties.getProperty("payModeText"), payMode);
        System.out.println("Selected  paymode:" + payMode);
        clickOnElement(paymentsAmazonPayProperties.getProperty("amazonPayPaymode"));
    }


    public void selectUPIReports() {

        clickOnElement(paymentsAmazonPayProperties.getProperty("upiReports"));
    }

    public void getCurrBatchSummary() {

        clickOnElement(paymentsAmazonPayProperties.getProperty("currentBatch"));
    }

    public void getLastBatchSummary() {
        clickOnElement(paymentsAmazonPayProperties.getProperty("lastBatch"));
    }

    public void getBatchDetailReport() {
        clickOnElement(paymentsAmazonPayProperties.getProperty("batchDetail"));
    }

}
