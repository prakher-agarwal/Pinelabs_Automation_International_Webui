package AndroidUI.POM.PaymentsApp;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonHelperPage extends BaseUtilsUI {
    static CommonHelperPage commonHelperPage;
    static Properties commonLocatorsProperties;
    static Properties deviceHome;
    static Properties paymentsUPIProperties;

    static Map<String, String> values = new HashMap<>();

    private CommonHelperPage() {

        deviceHome = CommonUtils.readPropertyfile("LocatorsRepo", "DeviceHome.properties");
        commonLocatorsProperties = CommonUtils.readPropertyfile("LocatorsRepo", "CommonLocators.properties");
        paymentsUPIProperties = CommonUtils.readPropertyfile("LocatorsRepo", "Payments_UPIPay.properties");
    }
    //13.234.97.42

    public static CommonHelperPage getInstance() {
        if (commonHelperPage == null)
            commonHelperPage = new CommonHelperPage();
        return commonHelperPage;
    }

    public void openPaytmFromHome() {
        if (isElementDisplayed(deviceHome.getProperty("imageView")))
            clickOnElement(deviceHome.getProperty("imageView"));
        clickOnElement(deviceHome.getProperty("homeAppPayments"));
    }

    public void clickOnFingerIcon() {
        clickOnElement(commonLocatorsProperties.getProperty("fingerIcon"));
        System.out.println("Clicked on Finger icon");
    }

    public void clickBrowseOtherOptions() {
        clickOnElement(commonLocatorsProperties.getProperty("browseOtherOptions"));
        System.out.println("Clicked on browse other options");
    }


    public void enterAmount(int amount) {

        clickOnElement(String.format(commonLocatorsProperties.getProperty("number"), amount));
        clickOnElement(commonLocatorsProperties.getProperty("00Number"));
        System.out.println("Amount requested : " + amount);
        clickOnElement(commonLocatorsProperties.getProperty("submitButton"));
        System.out.println("Clicked on submit amount");
    }

    public void selectUPIpaymode(String paymode) {
        if (paymode.equalsIgnoreCase("ICICI")) {
            if (isElementDisplayed(paymentsUPIProperties.getProperty("iciciOption")))
                clickOnElement(paymentsUPIProperties.getProperty("iciciOption"));
            System.out.println("Selected ICICI Bank");
        } else if (paymode.equalsIgnoreCase("Amazon Pay")) {
            if (isElementDisplayed(paymentsUPIProperties.getProperty("amazonPayOption")))
                clickOnElement(paymentsUPIProperties.getProperty("amazonPayOption"));
            System.out.println("Selected AmazonPay Bank");
        }
    }


    private void selectGetStatus() {

        clickOnElement(commonLocatorsProperties.getProperty("getStatus"));
    }

    public void getLastTransaction() {
        selectGetStatus();
        clickOnElement(commonLocatorsProperties.getProperty("lastTransaction"));
        System.out.println("Clicked on last transaction");
    }

    public void getAnyTransaction(int rocID, int batchNumber) {
        selectGetStatus();
        clickOnElement(commonLocatorsProperties.getProperty("anyTransaction"));
        enterInvoiceNumber(CommonUtils.generateRandonNumber(5));
        enterBatchID(batchNumber);
        enterROCID(rocID);
//        if (isElementDisplayed(paymentsReceipt.getProperty("invalidIsoPacketError"))) {
//            clickOnElement(paymentsReceipt.getProperty("dismissError"));
//            throw new NotFoundException("Please check Batch ID in Database, Error msg : Invalid ISO Packet");
//        }
//         validateClientAndMID(paymentsReceipt.getProperty("clientIDMID"));

    }

    public void clickProceedOnReceipt() {
        clickOnElement(commonLocatorsProperties.getProperty("proceedButton"));
    }

    public void clickPrintReceiptCopy() {
        clickOnElement(commonLocatorsProperties.getProperty("printButton"));
    }

    public void enterBatchID(int batchID) {
        if (isElementDisplayed(commonLocatorsProperties.getProperty("enterBatchIDHeading")))
            setElementText(commonLocatorsProperties.getProperty("batchID"), Integer.toString(batchID));
        System.out.println("Entered batch Id " + batchID);
        clickOnElement(commonLocatorsProperties.getProperty("submitButton"));
    }

    public void enterROCID(int rocID) {
        if (isElementDisplayed(commonLocatorsProperties.getProperty("enterROCHeading")))
            setElementText(commonLocatorsProperties.getProperty("rocID"), Integer.toString(rocID));
        System.out.println("Entered ROCID " + rocID);
        clickOnElement(commonLocatorsProperties.getProperty("submitButton"));
    }

    public void selectReprint() {
        clickOnElement(paymentsUPIProperties.getProperty("reprint"));
        System.out.println("Clicked on Reprint option under UPI");
    }

    public void enterInvoiceNumber(int invoiceNumber) {
        if (isElementDisplayed(commonLocatorsProperties.getProperty("invoiceHeader"))) {
            System.out.println("On Invoice page");
            setElementText(commonLocatorsProperties.getProperty("billingInvoiceNumber"), Integer.toString(invoiceNumber));
            System.out.println("Entered invoice number: " + invoiceNumber);
            clickOnElement(commonLocatorsProperties.getProperty("submitButton"));
            System.out.println("Submitted invoice number");
        }
        else
            System.out.println("Invoice text box not displayed");
    }

    public String scanQR() {
        System.out.println("QR Code Displayed");
        return decodeQr(commonLocatorsProperties.getProperty("qRCode"));
    }

    private Map<String, String> getKeyValueFromQR(String qrString) {
        qrString = qrString.split("\\?")[1];
        String[] arr = qrString.split("&");
        for (String d : arr) {
            String[] keyValue = d.split("=");
            values.put(keyValue[0], keyValue[1]);
        }
//        vals.entrySet().forEach(valss -> {
//            System.out.println(valss.getKey() + " " + valss.getValue());
//        });

        return values;
    }

    public String getValueFromQR(String key) {
        values = getKeyValueFromQR(scanQR());
        String value;
        if (key.equals("tr")) {
            value = values.get("tr");
            value = value.substring(value.lastIndexOf("S") + 1);
            System.out.println(value);
        } else
            value = values.get(key);
        return value;
    }

    public String validateClientAndMID(String key) {
        System.out.println(getElementText(commonLocatorsProperties.getProperty("clientIDMID")));
        return fetchReceiptValues(getElementText(commonLocatorsProperties.getProperty("clientIDMID"))).get(key);
    }

    public String validateCompletionStatus() {
        return getElementText(commonLocatorsProperties.getProperty("upiPaymentComplete"));
    }

    public void printReceipt(String yesOrno) {
        if (yesOrno.equalsIgnoreCase("Yes"))
            clickOnElement(commonLocatorsProperties.getProperty("yesBotton"));
        else if (yesOrno.equalsIgnoreCase("No")) {
            clickOnElement(commonLocatorsProperties.getProperty("noButton"));
        }
    }

    public Map<String, String> fetchReceiptValues(String param) {

        String[] array = param.split(" :");
        String[] array1 = array[1].split(" ");
        values.put(array[0], array1[0]);
        values.put(array1[1], array[2]);
        return values;
    }
}
