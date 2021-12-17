package AndroidUI.POM.PaymentsApp;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PaymentsAmazonPayValidationsPage extends BaseUtilsUI {

    static PaymentsAmazonPayValidationsPage paymentsAmazonPayValidationsPage;
    static Properties commonLocatorsProperties;
    static Properties deviceHome;
    static Properties paymentsInvoiceNumProperties;
    static Properties paymentsAmazonPayProperties;
    static Properties paymentsPlutusPlusProperties;
    static Properties paymentsReceipt;
    static Properties paymentsUPIGetStatus;
    static Properties paymentsQRCodeProperties;
    static Properties paymentsUPIProperties;
    static Map<String, String> values = new HashMap<>();

    private PaymentsAmazonPayValidationsPage() {

        commonLocatorsProperties = CommonUtils.readPropertyfile("LocatorsRepo", "CommonLocators.properties");
        paymentsAmazonPayProperties = CommonUtils.readPropertyfile("LocatorsRepo", "Payments_AmazonPay.properties");
    }


    public static PaymentsAmazonPayValidationsPage getInstance() {
        if (paymentsAmazonPayValidationsPage == null)
            paymentsAmazonPayValidationsPage = new PaymentsAmazonPayValidationsPage();
        return paymentsAmazonPayValidationsPage;
    }

    public void selectAmazonPaySale() {
        clickOnElement(paymentsAmazonPayProperties.getProperty("amazonPaySale"));
    }

    public void selecthPaymentMode(String payMode) {
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
