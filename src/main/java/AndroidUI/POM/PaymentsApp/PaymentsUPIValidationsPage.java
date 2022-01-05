package AndroidUI.POM.PaymentsApp;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PaymentsUPIValidationsPage extends BaseUtilsUI {

    static PaymentsUPIValidationsPage paymentsHomePage;
    static Properties deviceHome;
    static Properties paymentsUPIProperties;
    static Properties commonLocatorsProperties;
    static Map<String, String> values = new HashMap<>();

    private PaymentsUPIValidationsPage() {

        deviceHome = CommonUtils.readPropertyfile("LocatorsRepo", "DeviceHome.properties");
        commonLocatorsProperties = CommonUtils.readPropertyfile("LocatorsRepo", "CommonLocators.properties");
        paymentsUPIProperties = CommonUtils.readPropertyfile("LocatorsRepo", "Payments_UPIPay.properties");
    }

    public static PaymentsUPIValidationsPage getInstance() {
        if (paymentsHomePage == null)
            paymentsHomePage = new PaymentsUPIValidationsPage();
        return paymentsHomePage;
    }

    public void clickPaymentMode() {
        System.out.println(commonLocatorsProperties.getProperty("payModeDropDown"));
        clickOnElement(commonLocatorsProperties.getProperty("payModeDropDown"));
        System.out.println("Clicked on Paymode");
    }

    public void searchPaymentMode(String payMode) {
        clickOnElement(commonLocatorsProperties.getProperty("searchButton"));
        setElementText(commonLocatorsProperties.getProperty("payModeText"), payMode);
        clickOnElement(commonLocatorsProperties.getProperty("payModeDropDown"));
        System.out.println("Searching for paymode:" + payMode);
    }

    public void selectUPISaleRequest() {
        clickOnElement(String.format(paymentsUPIProperties.getProperty("upiSaleRequest"), "UPI"));
        System.out.println("Clicked on upiSalesRequest");
    }
    public void selectVoid() {
        clickOnElement(paymentsUPIProperties.getProperty("void"));
        System.out.println("Clicked on void");
    }
}
