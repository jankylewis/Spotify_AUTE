package se.requestProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import se.utility.apiUtil.RestUtil;

import java.util.HashMap;

public class AvailableGenreSeedProcessor extends BaseProcessor {

    //region Introducing constructors

    private AvailableGenreSeedProcessor() {
        super();
    }

    private AvailableGenreSeedProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Processing an instance

    public static final AvailableGenreSeedProcessor INSTANCE = getInstance();

    private static final class AvailableGenreSeedProcessorHelper {
        private static final AvailableGenreSeedProcessor _INSTANCE =
                new AvailableGenreSeedProcessor();
    }

    private static AvailableGenreSeedProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return AvailableGenreSeedProcessorHelper._INSTANCE;
    }

    //endregion

    private final String getAvailableGenreSeedUri = "https://api.spotify.com/v1/recommendations/available-genre-seeds";

    //region Services regarding API requests

    public Pair<AvailableGenreSeedProcessor, Response> getAvailableGenreSeed() {

        HashMap<RestUtil, Response> response = _requestProcessor.sendAuthenticatedRequestWithResponse(
                getAvailableGenreSeedUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return Pair.with(INSTANCE, response.get(_requestProcessor));
    }

    //endregion


}