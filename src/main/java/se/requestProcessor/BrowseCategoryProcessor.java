package se.requestProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import se.utility.StringUtil;
import se.utility.apiUtil.RestUtil;

import java.util.Arrays;
import java.util.HashMap;

public class BrowseCategoryProcessor extends BaseProcessor {

    //region Introducing constructors

    private BrowseCategoryProcessor() {
        super();
    }
    private BrowseCategoryProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Processing instance
    public static final BrowseCategoryProcessor INSTANCE = getInstance();

    private static BrowseCategoryProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return BrowseCategoryProcessorHelper._INSTANCE;
    }

    private static final class BrowseCategoryProcessorHelper {
        private static final BrowseCategoryProcessor _INSTANCE =
                new BrowseCategoryProcessor();
    }

    //endregion

    private final String browseCategoriesUri = "https://api.spotify.com/v1/browse/categories";

    //region Making requests to get list of browse categories

    //Blocking access to this method from others
    public synchronized Pair<BrowseCategoryProcessor, Response> getBrowseCategoriesSuccessfully() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                browseCategoriesUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public Pair<BrowseCategoryProcessor, Response> getBrowseCategoriesUnsuccessfully() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                StringUtil.appendStrings(Arrays.asList(browseCategoriesUri, "/", faker.produceFakeUuid().toString())),
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public void getMusicType() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                browseCategoriesUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        _requestProcessor._get();

    }

    //endregion

    //region Verifications

    public void verifyBrowseCategoriesRequestResponseSttCode(Response response) {

        Pair<Boolean, Integer> result = verifyResponseStatusCodeWentGreen(response);

        if (result.getValue0()) {
            verificationWentPassed();
        }
        else {
            LOGGER.error("Response status code came different with the expected status code! ");
            LOGGER.info("Actual status code >< Expected status code: " + result.getValue1() + " >< " + apiConstant.GREEN_STATUS);
            verificationWentFailed();
        }
    }

    //endregion

    public static void main(String []args) {
        INSTANCE.getMusicType();
    }
}
