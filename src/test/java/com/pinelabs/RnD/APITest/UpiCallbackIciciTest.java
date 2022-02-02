package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.UpiCallbackIcici;
import org.testng.annotations.Test;

public class UpiCallbackIciciTest extends TestUtilAPI {
    @Test
    public void m1(){
       UpiCallbackIcici upiCallbackIcici = getUpicallbackIciciInstance(UpiCallbackIcici.defaultrequest);
       upiCallbackIcici.getRequest().setMerchantTranId("TES17916770000033");
       upiCallbackIcici.createAndExecute();
    }
}
