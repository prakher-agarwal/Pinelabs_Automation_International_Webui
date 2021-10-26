package AndroidUI.POM.PaymentsApp;

import API.Base.BaseUtilsAPI;
import AndroidUI.Base.BaseUtilsUI;
import AndroidUI.POM.IrisApp.IrisHomePage;
import Base.CommonUtils;
import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PaymentsHomePage extends BaseUtilsUI {

    static PaymentsHomePage paymentsHomePage;
    static Properties locatorProp, deviceProp;
    static Map<String, String> values;

    private PaymentsHomePage() {

        locatorProp = CommonUtils.readPropertyfile("LocatorsRepo", "PaymentsHome.properties");
        deviceProp = CommonUtils.readPropertyfile("CommonProperties", "Device.properties");
        values = new HashMap<>();
    }

    public static PaymentsHomePage getInstance() {
        if (paymentsHomePage == null)
            paymentsHomePage = new PaymentsHomePage();
        return paymentsHomePage;
    }

    public void clickOnFingerIcon() {
        clickOnElement(locatorProp.getProperty("FingerIcon"));
        System.out.println("Clicked on Finger icon");
    }

    public void clickBrowseOtherOptions() {
        clickOnElement(locatorProp.getProperty("BrowseOtherOptions"));
        System.out.println("Clicked on browse other options");
    }

    public void SearchPaymentMode(String payMode) {
        clickOnElement(locatorProp.getProperty("SearchButton"));

        setElementText(locatorProp.getProperty("payModeText"), payMode);

        clickOnElement(locatorProp.getProperty("payModeDropDown"));
        System.out.println("Clicked on Paymode: " + payMode);
        clickOnElement(locatorProp.getProperty("upiSaleRequest"));
        System.out.println("Clicked on upiSalesRequest");

    }

    public void enterAmount() {

        clickOnElement(locatorProp.getProperty("1Number"));
        clickOnElement(locatorProp.getProperty("00Number"));
        System.out.println("Amount requested : 1");
        clickOnElement(locatorProp.getProperty("submitButton"));
        System.out.println("Clicked on submit amount");
        setElementText(locatorProp.getProperty("billingInvoiceNumber"), "123456");
        System.out.println("Entered invoice number");
        clickOnElement(locatorProp.getProperty("submit"));
        System.out.println("Submitted invoice number");
      //  clickOnElement(locatorProp.getProperty("iciciOption"));
        System.out.println("Selected ICICI Bank");
       String qrContent= decodeQr(locatorProp.getProperty("QRCode"));

        System.out.println("QR Code Generated");
    }

}
