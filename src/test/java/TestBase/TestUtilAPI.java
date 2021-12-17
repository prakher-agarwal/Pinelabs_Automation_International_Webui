package TestBase;

import API.Builders.GetJWTToken;
import API.Builders.IrisGetParametersFromPineCloud;
import API.Builders.UpiCallbackIcici;
import org.testng.annotations.BeforeSuite;

public class TestUtilAPI {
    public static IrisGetParametersFromPineCloud getIrisGetParametersFromPineCloud;
    public static GetJWTToken getJwtTokenInstance;

    @BeforeSuite
    public void launch() {
//    getIrisGetParametersFromPineCloud = getIrisGetParametersFromPineCloud();
//    getJwtTokenInstance = getJwtTokenInstance();
    }

    public UpiCallbackIcici getUpicallbackIciciInstance(String request) {
        return UpiCallbackIcici.getInstance(request);
    }

    public IrisGetParametersFromPineCloud getIrisGetParametersFromPineCloud(String request) {
        getIrisGetParametersFromPineCloud = IrisGetParametersFromPineCloud.getInstance(request);
        return getIrisGetParametersFromPineCloud;
    }

    public static GetJWTToken getJwtTokenInstance(String request) {
        getJwtTokenInstance = GetJWTToken.getInstance(request);
        return getJwtTokenInstance;
    }
}
