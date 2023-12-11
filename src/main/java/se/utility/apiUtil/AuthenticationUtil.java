package se.utility.apiUtil;

import io.restassured.http.ContentType;
import org.javatuples.Pair;
import se.model.apiModel.requestModel.AuthenticationModel;

import java.util.Collection;
import java.util.List;

public class AuthenticationUtil {

    private static final BaseRestUtil BASE_REST_UTIL = BaseRestUtil.INSTANCE;
    private static final String AUTHENTICATION_URI = "https://accounts.spotify.com/api/token";

    protected static String getAccessToken() {

        AuthenticationModel authenticationModel = new AuthenticationModel();

        Collection<Pair<Object, Object>> requestedForm =
                List.of(
                        Pair.with("grant_type", authenticationModel.getGrantType()),
                        Pair.with("client_id", authenticationModel.getClientId()),
                        Pair.with("client_secret", authenticationModel.getClientSecret())
                );

        BASE_REST_UTIL.sendRequest(
                AUTHENTICATION_URI,
                requestedForm,
                ContentType.URLENC,
                BaseRestUtil.EMethod.POST
        );

        return BASE_REST_UTIL.getPropertyValue("access_token");
    }
}
