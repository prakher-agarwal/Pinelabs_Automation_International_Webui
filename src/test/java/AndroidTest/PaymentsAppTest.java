package AndroidTest;

import API.Builders.UpiCallbackIcici;
import AndroidUI.POM.DeviceHomePage;
import AndroidUI.POM.PaymentsApp.PaymentsHomePage;
import TestBase.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class PaymentsAppTest extends TestUtils {
    PaymentsHomePage paymentsHomePage;
    DeviceHomePage deviceHomePage;
    UpiCallbackIcici upiCallbackIciciInstance;

    @BeforeClass
    public void getInstances() {
        paymentsHomePage = getPaymentsHomePageInstance();
        deviceHomePage = getDeviceHomePageInstance();
        upiCallbackIciciInstance = UpiCallbackIcici.getInstance(UpiCallbackIcici.defaultrequest);
    }

    @Test
    public void navigateToBrowse() {
        deviceHomePage.openPaymentsApp();
        paymentsHomePage.clickOnFingerIcon();
        paymentsHomePage.clickBrowseOtherOptions();
        paymentsHomePage.SearchPaymentMode("UPI");
        paymentsHomePage.enterAmount();

        upiCallbackIciciInstance.getRequest().setMerchantTranId("5652000011");
        upiCallbackIciciInstance.getRequest().setTxnStatus("SUCCESS");
        upiCallbackIciciInstance.createAndExecute();

    }

    @Test
    public void check() {
        String s = "upi://pay?pa=testupi.105546@icici&pn=sandeep&mc=5651&tr=TES5652000011&cu=INR&am=1.00";
//URL url ="upi://pay?pa=testupi.105546@icici&pn=sandeep&mc=5651&tr=TES5652000011&cu=INR&am=1.00";
        //     String query = url.getQuery();
        String queryparams = s.split("\\?")[1];
        String[] ar = queryparams.split("=");
        for(int i=0;i<ar.length;i++){

        }
        System.out.println(s.split("\\?")[1]);

    }

}
