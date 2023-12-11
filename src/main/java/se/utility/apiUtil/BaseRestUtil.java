package se.utility.apiUtil;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static io.restassured.RestAssured.given;

public class BaseRestUtil {

    //region Processing BaseRestUtil instance

    protected static final BaseRestUtil INSTANCE = getInstance();

    private BaseRestUtil() {}

    private static BaseRestUtil getInstance() {
        return BaseRestUtilHelper._INSTANCE;
    }

    private static final class BaseRestUtilHelper {
        private static final BaseRestUtil _INSTANCE = new BaseRestUtil();
    }

    //endregion

    private final RequestSpecification requestSpecification = given();
    private Response response;
    private String _requestedUri;
    private JsonPath jsonPath;

    private BaseRestUtil setRequestedUri(String requestedUri) {
        _requestedUri = requestedUri;
        return INSTANCE;
    }

    private RequestSpecification buildUrlencodedForm(
            @NotNull Collection<Pair<Object, Object>> pairs
    ) {

        Collection<Pair<Object, Object>> unmodifiablePairs =
                Collections.unmodifiableCollection(pairs);

        for (Pair<?, ?> pair : unmodifiablePairs) {

            String name = pair.getValue0().toString();
            String value = pair.getValue1().toString();

            requestSpecification.formParam(name, value);
        }

        return requestSpecification;
    }

    //region Sending requests with methods

    private Response sendGetRequest() {
        return response = requestSpecification.get(_requestedUri);
    }

    private Response sendPostRequest() {
        return response = requestSpecification.post(_requestedUri);
    }

    private Response sendPatchRequest() {
        return response = requestSpecification.patch(_requestedUri);
    }

    private Response sendHeadRequest() {
        return response = requestSpecification.head(_requestedUri);
    }

    private Response sendOptionsRequest() {
        return response = requestSpecification.options(_requestedUri);
    }

    private Response sendPutRequest() {
        return response = requestSpecification.put(_requestedUri);
    }

    private Response sendDeleteRequest() {
        return response = requestSpecification.delete(_requestedUri);
    }

    //endregion

    //Getting property value from response
    protected String getPropertyValue(String property) {
        jsonPath = new JsonPath(response.asPrettyString());
        return jsonPath.get(property);
    }

    public BaseRestUtil sendRequest(
            String requestedUri,
            @Nullable Collection<Pair<Object, Object>> requestedBody,
            @Nullable ContentType requestedContentType,
            EMethod requestedMethod
            ) {

        setAccessToken();

        setRequestedUri(requestedUri);

        //Invoking a requested body if needed
        if (requestedContentType != null && requestedBody != null) {
            switch (requestedContentType) {
                case URLENC -> buildUrlencodedForm(requestedBody);
            }
        }

        switch (requestedMethod) {
            case GET -> sendGetRequest();
            case POST -> sendPostRequest();
            case PUT -> sendPutRequest();
            case HEAD -> sendHeadRequest();
            case PATCH -> sendPatchRequest();
            case DELETE -> sendDeleteRequest();
            case OPTIONS -> sendOptionsRequest();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        BaseRestUtil BRU = BaseRestUtil.getInstance();
//        Collection<Pair<Object, Object>> form =
//                List.of(
//                        Pair.with("grant_type", "client_credentials"),
//                        Pair.with("client_id", "ff4df67329594a35a57ad06dcd53605f"),
//                        Pair.with("client_secret", "363912205fc049b3b49d6210c08182f8")
//                );
//
//
//        BRU.setRequestedUri("https://accounts.spotify.com/api/token");
//        BRU.buildUrlencodedForm(form);
//        Response res = BRU.sendPostRequest();
//
//        String x_ = BRU.getPropertyValue("access_token");
//        System.out.print(x_);

//        JsonPath js = new JsonPath(res.prettyPrint());
//        System.out.print(js.getString("expires_in"));

        BRU.sendRequest(
                "https://api.spotify.com/v1/browse/categories",
                null,
                null,
                EMethod.GET
        );
    }

    private BaseRestUtil setAccessToken() {
        String accessToken = AuthenticationUtil.getAccessToken();
        requestSpecification.given()
                .header("Authorization", "Bearer " + accessToken);
        return INSTANCE;
    }

    //region API methods

    public enum EMethod {
        GET,
        POST,
        PUT,
        PATCH,
        DELETE,
        OPTIONS,
        HEAD
    }

    //endregion
}
