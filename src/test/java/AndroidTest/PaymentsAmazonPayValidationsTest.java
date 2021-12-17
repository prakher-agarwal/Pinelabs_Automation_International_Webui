package AndroidTest;

import API.Builders.UpiAmazonPay;
import API.Builders.UpiCallbackIcici;
import AndroidUI.Base.BaseUtilsUI;
import AndroidUI.POM.DeviceHomePage;
import AndroidUI.POM.PaymentsApp.CommonHelperPage;
import AndroidUI.POM.PaymentsApp.PaymentsAmazonPayValidationsPage;
import AndroidUI.POM.PaymentsApp.PaymentsUPIValidationsPage;
import Base.CommonUtils;
import TestBase.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentsAmazonPayValidationsTest extends TestUtils {
    PaymentsAmazonPayValidationsPage paymentsAmazonPayInstance;
    DeviceHomePage deviceHomePageInstance;
    UpiAmazonPay upiAmazonPayInstance;
    CommonHelperPage commonHelperPageInstance;
    PaymentsUPIValidationsPage paymentsUPIValidationInstance;

    @BeforeClass
    public void getInstances() {
        BaseUtilsUI.setUpConnection();
        //paymentsUPIValidationInstance = getPaymentsAmazonPayValidationsPage();
        paymentsAmazonPayInstance = getPaymentsAmazonPayValidationsPage();
        deviceHomePageInstance = getDeviceHomePageInstance();
        commonHelperPageInstance = getCommonHelperPageInstance();
        paymentsUPIValidationInstance = getPaymentsUPIValidationInstance();
        upiAmazonPayInstance = UpiAmazonPay.getInstance(UpiAmazonPay.defaultrequest);
    }

    @Test(description = "Validate if the transaction is done successfully using amazonPay paymode")
    public void paymentsAmazonPay_TC001() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("Amazon Pay");
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        //paymentsUPIValidationInstance.selectUPISaleRequest();
        paymentsAmazonPayInstance.selectAmazonPaySale();
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(6));
//      commonHelperPageInstance.selectUPIpaymode("Amazon Pay");
        commonHelperPageInstance.scanQR();
        String sellerOrderID = commonHelperPageInstance.getValueFromQR("tr");
        String merchantID = commonHelperPageInstance.getValueFromQR("mi");
        String totalAmt = commonHelperPageInstance.getValueFromQR("am");
        upiAmazonPayInstance.getRequest().setMerchantID(merchantID);
        upiAmazonPayInstance.getRequest().setOrderTotalAmount(totalAmt);
        upiAmazonPayInstance.getRequest().setSellerOrderId(sellerOrderID);
        upiAmazonPayInstance.createAndExecute();

    }

    @Test(description = "Validate the status of Last amazonPay transaction")
    public void paymentsAmazonPay_TC002() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        commonHelperPageInstance.getLastTransaction();
    }

    @Test(description = "Validate the status of any amazonPay transaction based on provided batch ID and ROC ID")
    public void paymentsAmazonPay_TC003() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay ");
        commonHelperPageInstance.getAnyTransaction(233, 9006);

    }

    @Test(description = "Validate the reprint receipt of  Last amazonPay transaction")
    public void paymentsAmazonPay_TC004() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getLastTransaction();

    }

    @Test(description = "Validate the reprint receipt of any amazonPay transaction")
    public void paymentsAmazonPay_TC005() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getAnyTransaction(233, 9006);
    }

    @Test(description = "Validate the amazonPay reorts of current batch summary")
    public void paymentsAmazonPay_TC006() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        paymentsAmazonPayInstance.selectUPIReports();
        paymentsAmazonPayInstance.getCurrBatchSummary();
        commonHelperPageInstance.getLastTransaction();

    }

    @Test(description = "Validate the amazonPay reports of Last batch summary")
    public void paymentsAmazonPay_TC007() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        paymentsAmazonPayInstance.selectUPIReports();
        paymentsAmazonPayInstance.getLastBatchSummary();
        commonHelperPageInstance.getAnyTransaction(233, 9006);
    }

    @Test(description = "Validate the amazonPay batch Detailed report")
    public void paymentsAmazonPay_TC008() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsAmazonPayInstance.selecthPaymentMode("Amazon Pay");
        paymentsAmazonPayInstance.selectUPIReports();
        paymentsAmazonPayInstance.getBatchDetailReport();
        commonHelperPageInstance.getAnyTransaction(233, 9006);
    }


}
