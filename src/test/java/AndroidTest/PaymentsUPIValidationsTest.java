package AndroidTest;

import API.Builders.UpiCallbackIcici;
import AndroidUI.Base.BaseUtilsUI;
import AndroidUI.POM.DeviceHomePage;
import AndroidUI.POM.PaymentsApp.CommonHelperPage;
import AndroidUI.POM.PaymentsApp.PaymentsUPIValidationsPage;
import Base.CommonUtils;
import TestBase.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PaymentsUPIValidationsTest extends TestUtils {
    PaymentsUPIValidationsPage paymentsUPIValidationInstance;
    DeviceHomePage deviceHomePageInstance;
    UpiCallbackIcici upiCallbackIciciInstance;
    CommonHelperPage commonHelperPageInstance;
    Map<String, String> value = new HashMap<>();

    @BeforeClass
    public void getInstances() {
        BaseUtilsUI.setUpConnection();
        paymentsUPIValidationInstance = getPaymentsUPIValidationInstance();
        deviceHomePageInstance = getDeviceHomePageInstance();
        commonHelperPageInstance = getCommonHelperPageInstance();
        upiCallbackIciciInstance = UpiCallbackIcici.getInstance(UpiCallbackIcici.defaultrequest);
    }

    @Test(description = "Validate the E2E UPI transaction through Payments App")
    public void iCICI_UPI_001() {

        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectUPISaleRequest();
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(6));
        // commonHelperPageInstance.selectUPIpaymode("ICICI");
        commonHelperPageInstance.scanQR();
        String merchID = commonHelperPageInstance.getValueFromQR("tr");
        upiCallbackIciciInstance.getRequest().setMerchantTranId(merchID);
        upiCallbackIciciInstance.getRequest().setTxnStatus("SUCCESS");
        upiCallbackIciciInstance.createAndExecute();

        String c = commonHelperPageInstance.validateClientAndMID("CLIENT ID");
        System.out.println("client id is" + c);
        String m = commonHelperPageInstance.validateClientAndMID("MID");
        System.out.println("Mid is " + m);
        String d = commonHelperPageInstance.validateCompletionStatus();
        System.out.println("completion status is " + d);
        Assert.assertEquals(c, "293188");
        Assert.assertEquals(m, "5651");
        Assert.assertEquals(d, "UPI SALE COMPLETE");
        commonHelperPageInstance.clickProceedOnReceipt();
        commonHelperPageInstance.printReceipt("NO");
        Assert.assertEquals(upiCallbackIciciInstance.getResponse().getErroCode(), "00");
        Assert.assertEquals(upiCallbackIciciInstance.getResponse().getErrorMsg(), "Success");

    }

    @Test(description = "Verify the ICICI UPI \"GetStatus- Last\" Transaction.")
    public void iCICI_UPI_003() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();

    }

    @Test(description = "Verify the ICICI UPI \"GetStatus- Any\" Transaction.")
    public void iCICI_UPI_004() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getAnyTransaction(233, 9006);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Verify the ICICI_UPI \"GetStatus\" Transaction with incorrect Batch ID.")
    public void iCICI_UPI_005() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getAnyTransaction(233, 94812);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Verify the ICICI_UPI \"GetStatus\" Transaction with incorrect ROC ID.")
    public void iCICI_UPI_005a() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getAnyTransaction(23312, 9006);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Verify the ICICI_UPI \"GetStatus\" Transaction with incorrect Batch ID and ROC ID.")
    public void iCICI_UPI_005b() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getAnyTransaction(23312, 900612);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    // add duplicate copy validation
    @Test(description = "Generate \"Reprint-Last\" transaction chargeslip after successful ICICI_UPI transaction.")
    public void iCICI_UPI_011() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Generate \"Reprint - Any\" transaction chargeslip after successful ICICI_UPI transaction.")
    public void iCICI_UPI_012() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getAnyTransaction(123, 9009);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Validate the void in UPI transaction")
    public void iCICI_UPI_013() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectVoid();
        commonHelperPageInstance.enterBatchID(9009);
        commonHelperPageInstance.enterROCID(122);
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    // add error assertion
    @Test(description = "Validate the void in UPI transaction for already void ROC ID")
    public void upiTransaction_TC007() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectVoid();
        commonHelperPageInstance.enterBatchID(9009);
        commonHelperPageInstance.enterROCID(123);
        commonHelperPageInstance.enterAmount(1);

    }

    @Test(description = "Validate the reprint receipt of last void UPI transaction  ")
    public void upiTransaction_TC008() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectVoid();
        commonHelperPageInstance.enterBatchID(9009);
        commonHelperPageInstance.enterROCID(123);
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.clickProceedOnReceipt();
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Validate the reprint receipt of last void UPI transaction  ")
    public void upiTransaction_TC009() {
        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectVoid();
        commonHelperPageInstance.enterBatchID(9009);
        commonHelperPageInstance.enterROCID(123);
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.clickProceedOnReceipt();
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();
    }


    //    @Test
//    public void chkdb() throws SQLException {
//        String connectionUrl =
//                "jdbc:sqlserver://192.168.101.69:1433;";
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//             Statement statement = connection.createStatement()) {
//            System.out.println("statement" + statement);
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    @Test(invocationCount = 2)
    public void check() {
        value.put("Client ID", "1234");
        value.put("m ID", "5678");
        for (Map.Entry<String, String> entry : value.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void chk2() {
        for (Map.Entry<String, String> entry : value.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}