//package api.jsonProcessor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

//public class JacksonJsonImpl implements Json {
//
//    private static final ThreadLocal<ObjectMapper> tlObjectMapper = new ThreadLocal<ObjectMapper>();
//    private static volatile JacksonJsonImpl _instance;
//
//    public JacksonJsonImpl() {
//
//    }
//
//    public static JacksonJsonImpl getInstance() {
//        if (_instance == null) {
//            synchronized (JacksonJsonImpl.class) {
//                if (_instance == null) {
//                    _instance = new JacksonJsonImpl();
//                }
//            }
//        }
//        return _instance;
//    }
//
//    public static ObjectMapper getObjectMapper() {
//        ObjectMapper objectMapper = tlObjectMapper.get();
//        if (objectMapper == null) {
//            objectMapper = new ObjectMapper();
//
//            objectMapper.setVisibilityChecker(
//                    objectMapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//            objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            tlObjectMapper.set(objectMapper);
//        }
//        return objectMapper;
//    }
//
//    public static ObjectMapper getObjectMapperNullFields() {
//        ObjectMapper objectMapper = tlObjectMapper.get();
//        if (objectMapper == null) {
//            objectMapper = new ObjectMapper();
//
//            objectMapper.setVisibilityChecker(
//                    objectMapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//            objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            tlObjectMapper.set(objectMapper);
//        }
//        return objectMapper;
//    }
//
//    public <T> String toJSon(T t) throws IOException {
//        try {
//            String json = getObjectMapper().writeValueAsString(t);
//            return json;
//        } catch (JsonGenerationException jge) {
//            throw jge;
//        } catch (JsonMappingException jme) {
//            throw jme;
//        } catch (IOException ioe) {
//            throw ioe;
//        }
//    }
//
//    public <T> T fromJson(String json, Class<T> clazz) throws IOException {
//
//        try {
//            T t = getObjectMapper().readValue(json, clazz);
//            return t;
//        } catch (JsonParseException jpe) {
//            throw jpe;
//        } catch (JsonMappingException jme) {
//            throw jme;
//        } catch (IOException ioe) {
//            throw ioe;
//        }
//    }
//
//    public <T> T responsefromJson(Response response, Class<T> clazz) throws IOException {
//        T t = null;
//        if (response.getStatusCode() != 400) {
//            t = fromJson(response.asString(), clazz);
//        }
//        return t;
//    }
//
//    public <T> T responsefromJsonfor400(Response response, Class<T> clazz) throws IOException {
//        T t = null;
//        t = fromJson(response.asString(), clazz);
//        return t;
//    }
//
//    public <T> T fromJson(String json, TypeReference typeRef) throws IOException {
//
//        try {
//            T t = getObjectMapper().readValue(json, typeRef);
//            return t;
//        } catch (JsonParseException jpe) {
//            throw jpe;
//        } catch (JsonMappingException jme) {
//            throw jme;
//        } catch (IOException ioe) {
//            throw ioe;
//        }
//    }
//}

//import api.BaseApi;
//import api.jsonProcessor.JacksonJsonImpl;
//import com.paytm.apiPojo.Subscription.FetchPaymentDetailsRequest;
//import com.paytm.apiPojo.Subscription.FetchPaymentDetailsResponse;
//import com.paytm.apiPojo.wallet.SubscriptionAPIInterface;
//import com.paytm.constants.Constants;
//import com.paytm.constants.LocalConfig;
//import com.paytm.enums.BasePathEnums;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class FetchPaymentDetails extends SubscriptionAPIInterface {
//
//    public static final String defaultRequest = "{ \"head\":{ \"clientId\":\"client1\", \"tokenType\": \"AES\", \"token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjbGllbnQxIiwibWlkIjoiUlVQQVlCNTg1Mzk4MzE3MDkxMDMiLCJ0aW1lc3RhbXAiOiIxNTg4MDQ5MTY4In0.nnRK3z8e6Hc61mKman9DaMWDl8eICLPuCrpfsjQaXTw\", \"timestamp\":\"1582529795512\" }, \"body\":{ \"subsId\":\"7141\", \"mid\":\"RUPAYB58539831709103\", \"pageNo\":\"1\" } }";
//    private Response response;
//    private FetchPaymentDetailsRequest fetchPaymentDetailsRequest;
//    private FetchPaymentDetailsResponse fetchPaymentDetailsResponse;
//
//    private Map<String, String> headerMap = new HashMap<>();
//
//    private String request;
//    private String basePath;
//    private String mid;
//
//    public FetchPaymentDetails(String request) {
//        setMethod(BaseApi.MethodType.POST);
//        setContentType(ContentType.JSON);
//        setBaseUri(LocalConfig.PGP_HOST);
//        setBasePath(Constants.WALLETAPIresource.Subscription.FETCHPAYMENTDETAILS);
//
//        this.request = request;
//        if (this.request != "") {
//            try {
//                fetchPaymentDetailsRequest = JacksonJsonImpl.getInstance().fromJson(this.request,
//                        FetchPaymentDetailsRequest.class);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void setMerchantGuid(String mGuid) {
//        this.mid = mGuid;
//        this.headerMap.put("mid", mGuid);
//        System.out.println("Mid is " + this.mid);
//    }
//
//    public FetchPaymentDetailsRequest getRequestPojo() {
//        return fetchPaymentDetailsRequest;
//    }
//
//    public void createRequestJsonAndExecute() {
//        try {
//            if (this.request != "")
//                this.request = JacksonJsonImpl.getInstance().toJSon(fetchPaymentDetailsRequest);
//            setMethod(BaseApi.MethodType.POST);
//            System.out.println("Updated request-----> " + this.request);
//            setBody(this.request);
//            response = execute();
//
//            fetchPaymentDetailsResponse = JacksonJsonImpl.getInstance().responsefromJson(response,
//                    FetchPaymentDetailsResponse.class);
//        } catch (IOException ie) {
//            ie.printStackTrace();
//        }
//    }
//
//    public Response getApiResponse() {
//        return response;
//    }
//
//    public FetchPaymentDetailsResponse getResponsePojo() {
//        return fetchPaymentDetailsResponse;
//    }
//
//    public void setAPIBasePath(String className) {
//        this.basePath = BasePathEnums.CheckStatus.valueOf(className).getName();
//        setBasePath(this.basePath);
//
//    }
//
//    @Override
//    public int gethttpResponseCode() {
//        // TODO Auto-generated method stub
//        return 0;

//    }

