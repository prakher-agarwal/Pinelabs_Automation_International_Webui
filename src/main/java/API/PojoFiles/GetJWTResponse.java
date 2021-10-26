package API.PojoFiles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GetJWTResponse {

    @JsonProperty("ErrCode")
    private Integer errCode;
    @JsonProperty("ResMsg")
    private String resMsg;
    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
