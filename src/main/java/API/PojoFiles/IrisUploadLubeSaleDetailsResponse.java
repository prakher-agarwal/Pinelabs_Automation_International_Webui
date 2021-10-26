package API.PojoFiles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class IrisUploadLubeSaleDetailsResponse {
    @JsonProperty("ErrCode")
    private Integer errCode;
    @JsonProperty("ResMsg")
    private String resMsg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
