package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.UpiCallbackIciciRequest;
import API.PojoFiles.UpiCallbackIciciResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;
import org.omg.CORBA.Request;


public class UpiCallbackIcici extends BaseUtilsAPI {
    static UpiCallbackIcici upiCallbackIcici;
    UpiCallbackIciciRequest upiCallbackIciciRequest;
    UpiCallbackIciciResponse upiCallbackIciciResponse;
    public static String defaultrequest = "{\"merchantId\":\"131122\",\"subMerchantId\":\"131122\",\"terminalId\":\"null\",\"merchantTranId\":\"5652000007\",\"PayerName\":\"VISHAL RATHORE\",\"PayerMobile\":\"0\",\"PayerVA\":\"vishal.rathore8@okhdfcbank\",\"PayerAmount\":\"1.0\",\"TxnStatus\":\"SUCCESS\"}";
    String request;
    private UpiCallbackIcici(String request) {
        this.request=request;
        upiCallbackIciciRequest = stringToJavaObject(this.request, UpiCallbackIciciRequest.class);


    }

    public static UpiCallbackIcici getInstance(String request) {
        if (upiCallbackIcici == null)
            upiCallbackIcici = new UpiCallbackIcici(request);
        return upiCallbackIcici;
    }


    public UpiCallbackIciciResponse createAndExecute() {
        request = javaObjectToString(upiCallbackIciciRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/authorize");
        upiCallbackIciciResponse = stringToJavaObject(response.asString(), UpiCallbackIciciResponse.class);
        return upiCallbackIciciResponse;
    }

    public UpiCallbackIciciResponse getResponse() {
        return upiCallbackIciciResponse;
    }

    public UpiCallbackIciciRequest getRequest() {
        return upiCallbackIciciRequest;
    }
}

