package APITest;

import API.Builders.UpiCallbackIcici;
import TestBase.TestUtilAPI;
import TestBase.TestUtils;
import org.testng.annotations.Test;

public class UpiCallbackIciciTest extends TestUtilAPI {
    @Test
    public void m1(){
       UpiCallbackIcici upiCallbackIcici = getUpicallbackIciciInstance(UpiCallbackIcici.defaultrequest);
       upiCallbackIcici.getRequest().setMerchantTranId("TES17916770000033");
       upiCallbackIcici.createAndExecute();
    }
}
