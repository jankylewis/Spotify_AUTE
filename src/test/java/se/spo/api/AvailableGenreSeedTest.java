package se.spo.api;

import io.restassured.response.Response;
import org.javatuples.Pair;
import org.testng.annotations.Test;
import se.requestProcessor.AvailableGenreSeedProcessor;

public class AvailableGenreSeedTest extends BaseApiTestService {

    private AvailableGenreSeedProcessor availableGenreSeedProcessor = AvailableGenreSeedProcessor.INSTANCE;

    @Test(
            priority = 1,
            testName = "SAAVAILABLEGENRESEED_01",
            description = "Verify Gospel type was included in the response when User made a request",
    )
    protected void spotifyApiTest_VerifyGospelTypeWasPresentedInTheResponse() {
        Pair<AvailableGenreSeedProcessor, Response> dataResponded =
                availableGenreSeedProcessor.getAvailableGenreSeed();

    }

}
