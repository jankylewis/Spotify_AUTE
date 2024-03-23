package se.utility.apiUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class _RestUtil {

    public _RestUtil() {}

    private RequestSpecification _requestSpecification;
    private Response _response;
    private String _requestUri;
    private JsonPath _jsonPath;

    {
        _requestSpecification = given();
    }

    
}
