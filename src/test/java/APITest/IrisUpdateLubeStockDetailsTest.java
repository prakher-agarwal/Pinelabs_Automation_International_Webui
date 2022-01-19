package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisUpdateLubeStockDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import CommonBase.CommonUtils;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUpdateLubeStockDetailsTest {

    @Test(description = "Validate if lube stock details are updated successfully")
    public void updateLubeStockDetails_TC001() {
        IrisUpdateLubeStockDetails irisUpdateLubeStockDetails = IrisUpdateLubeStockDetails.getInstance(IrisUpdateLubeStockDetails.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821397407", GetJWTToken.defaultrequest);
        irisUpdateLubeStockDetails.getRequest().setHardwareId("0821397407");
        irisUpdateLubeStockDetails.getRequest().setQuantity(89763);
        irisUpdateLubeStockDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisUpdateLubeStockDetails.getResponse().getResMsg(), "Successfully updated the dry stock details in DB");
       // FindIterable<Document> a = CommonUtils.sortWithcolumnName("PL_IRIS_DRY_STOCK_SALE_COLLECTIONS", "LUBE_SALE_DATE_TIME");
    Document d=    CommonUtils.findRowBasedOnColumn("PL_IRIS_DRY_STOCK_UPDATE_COLLECTIONS", "QUANTITY",89763);
        System.out.println("Fetched" +d.get("QUANTITY"));
       // Assert.assertTrue(8976d.get("QUANTITY"););
    }
}
