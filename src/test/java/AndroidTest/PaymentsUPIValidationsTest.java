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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentsUPIValidationsTest extends TestUtils {
    PaymentsUPIValidationsPage paymentsUPIValidationInstance;
    DeviceHomePage deviceHomePageInstance;
    UpiCallbackIcici upiCallbackIciciInstance;
    CommonHelperPage commonHelperPageInstance;

    @BeforeClass
    public void getInstances() {
        BaseUtilsUI.setUpConnection();
        paymentsUPIValidationInstance = getPaymentsUPIValidationInstance();
        deviceHomePageInstance = getDeviceHomePageInstance();
        commonHelperPageInstance = getCommonHelperPageInstance();
        upiCallbackIciciInstance = UpiCallbackIcici.getInstance(UpiCallbackIcici.defaultrequest);
    }

    @Test(description = "Validate the E2E UPI transaction through Payments App")
    public void upiTransaction_TC001() {

        deviceHomePageInstance.openPaymentsApp();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectUPISaleRequest();
        commonHelperPageInstance.enterAmount(1);
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(6));
        commonHelperPageInstance.selectUPIpaymode("ICICI");
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

    @Test(description = "Validate the status of Last UPI transaction")
    public void upiTransaction_TC002() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();

    }

    @Test(description = "Validate the status of any UPI transaction based on provided batch ID and ROC ID")
    public void upiTransaction_TC003() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.getAnyTransaction(233, 9006);
        commonHelperPageInstance.clickProceedOnReceipt();

    }

    @Test(description = "Validate the reprint receipt of  Last UPI transaction")
    public void upiTransaction_TC004() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getLastTransaction();
        commonHelperPageInstance.enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Validate the reprint receipt of any UPI transaction")
    public void upiTransaction_TC005() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        commonHelperPageInstance.selectReprint();
        commonHelperPageInstance.getAnyTransaction(233, 9006);
        commonHelperPageInstance.clickProceedOnReceipt();
    }

    @Test(description = "Validate the void in UPI transaction")
    public void upiTransaction_TC006() {
        commonHelperPageInstance.openPaytmFromHome();
        commonHelperPageInstance.clickOnFingerIcon();
        commonHelperPageInstance.clickBrowseOtherOptions();
        paymentsUPIValidationInstance.searchPaymentMode("UPI");
        paymentsUPIValidationInstance.selectVoid();
        commonHelperPageInstance.enterBatchID(9008);
        commonHelperPageInstance.enterROCID(182);
        commonHelperPageInstance.enterAmount(1);
    }

    @Test
    public void chkdb() throws SQLException {
        String connectionUrl =
                "jdbc:sqlserver://192.168.101.69:1433;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {
            System.out.println("statement" + statement);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}