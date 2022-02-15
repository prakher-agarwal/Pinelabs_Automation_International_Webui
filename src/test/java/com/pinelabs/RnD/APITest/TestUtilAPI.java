package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisGetParametersFromPineCloud;
import com.pinelabs.RnD.API.Builders.UpiCallbackIcici;
import com.pinelabs.RnD.CommonUtils.ExtentSparkReportUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestUtilAPI extends ExtentSparkReportUtility {
    public static IrisGetParametersFromPineCloud getIrisGetParametersFromPineCloud;
    public static GetJWTToken getJwtTokenInstance;

    @BeforeSuite
    public void launch() {
        ExtentSparkReportUtility.initialise();
    }

    @BeforeMethod
    public void setmethodAndCurrentClass(Method method, ITestContext result) {
        Test test = method.getAnnotation(Test.class);
        setMethod(method, test);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        System.out.println("In after Method");
        ExtentSparkReportUtility.generateReportAPI(result);

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
