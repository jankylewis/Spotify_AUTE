package se.requestProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import se.utility.apiUtil.RestUtil;

import java.util.HashMap;

public class MarketProcessor extends BaseProcessor {

    //region Introducing constructors

    private MarketProcessor() {
        super();
    }

    private MarketProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Handling instance

    public static final MarketProcessor INSTANCE = getInstance();

    private static MarketProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return MarketProcessorHelper.INSTANCE;
    }

    private static final class MarketProcessorHelper {
        private static final MarketProcessor INSTANCE = new MarketProcessor();
    }

    //endregion

    //region URIs

    private final String marketBrowsingUri = "https://api.spotify.com/v1/markets";

    //endregion

    //region Making requests

    public Pair<MarketProcessor, Response> getMarkets() {       //Normal request

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
            marketBrowsingUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public Pair<MarketProcessor, Response> getMarkets(String abnormalSuffix) {       //Abnormal request

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                marketBrowsingUri + "/" + abnormalSuffix,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    public Pair<MarketProcessor, Response> getMarketsWithExpiredToken(String expiredToken) {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                expiredToken,
                marketBrowsingUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    //endregion

    //region Verifications

    public void verifyRetrievingMarketsSuccessfully(Response response) {

        Pair<Boolean, Integer> result = verifyResponseStatusCodeWentGreen(response);

        if (result.getValue0()) {
            verificationWentPassed();
            return;
        }

        LOGGER.error("Response status code came different with the expected status code! ");
        LOGGER.info("Actual status code >< Expected status code: " + result.getValue1() + " >< " + apiConstant.GREEN_STATUS);
        verificationWentFailed();
    }

    public void verifyRetrievingMarketsUnsuccessfully(Response response) {      //Expectations: Status code was 404
        Pair<Boolean, Integer> result = verifyResponseStatusCodeWent404(response);

        if (result.getValue0()) {
            verificationWentPassed();
            return;
        }

        LOGGER.error("Response status code came different with the expected status code! ");
        LOGGER.info("Actual status code >< Expected status code: "
                + result.getValue1() + " >< " + apiConstant.SERVICE_NOT_FOUND);

        verificationWentFailed();
    }

    //endregion
}
