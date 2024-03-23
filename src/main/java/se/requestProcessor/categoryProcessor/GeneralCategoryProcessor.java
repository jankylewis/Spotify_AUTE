package se.requestProcessor.categoryProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import se.requestProcessor.BaseProcessor;
import se.utility.StringUtil;
import se.utility.apiUtil.RestUtil;

import java.util.Arrays;
import java.util.HashMap;

public class GeneralCategoryProcessor extends BaseProcessor {

    //region Introducing constructors

    private GeneralCategoryProcessor() {
        super();
    }
    private GeneralCategoryProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Processing instance
    public static final GeneralCategoryProcessor INSTANCE = getInstance();

    private static GeneralCategoryProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return BrowseCategoryProcessorHelper._INSTANCE;
    }

    private static final class BrowseCategoryProcessorHelper {
        private static final GeneralCategoryProcessor _INSTANCE =
                new GeneralCategoryProcessor();
    }

    //endregion

    private final String categoriesBrowsingUri = "https://api.spotify.com/v1/browse/categories";

    //region Making requests to get list of browse categories

    //Blocking access to this method from others
    public Pair<GeneralCategoryProcessor, Response> getBrowseCategoriesSuccessfully() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                categoriesBrowsingUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public Pair<GeneralCategoryProcessor, Response> getBrowseCategoriesUnsuccessfully() {

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
