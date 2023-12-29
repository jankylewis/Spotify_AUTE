package se.requestProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import se.utility.StringUtil;
import se.utility.apiUtil.RestUtil;

import java.util.Arrays;
import java.util.HashMap;

public class CategoryProcessor extends BaseProcessor {

    //region Introducing constructors

    private CategoryProcessor() {
        super();
    }
    private CategoryProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Processing instance
    public static final CategoryProcessor INSTANCE = getInstance();

    private static CategoryProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return BrowseCategoryProcessorHelper._INSTANCE;
    }

    private static final class BrowseCategoryProcessorHelper {
        private static final CategoryProcessor _INSTANCE =
                new CategoryProcessor();
    }

    //endregion

    private final String categoriesBrowsingUri = "https://api.spotify.com/v1/browse/categories";

    //region Making requests to get list of browse categories

    //Blocking access to this method from others
    public Pair<CategoryProcessor, Response> getBrowseCategoriesSuccessfully() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                categoriesBrowsingUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public Pair<CategoryProcessor, Response> getBrowseCategoriesUnsuccessfully() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                StringUtil.appendStrings(Arrays.asList(categoriesBrowsingUri, "/", apiFaker.produceFakeUuid().toString())),
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
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
}
