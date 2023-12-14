package se.spo.api;

import io.restassured.response.Response;
import org.javatuples.Pair;
import org.testng.annotations.Test;
import se.requestProcessor.BrowseCategoryProcessor;

public class BrowseCategoryTest extends BaseApiTestService {

    private BrowseCategoryProcessor browseCategoryProcessor = BrowseCategoryProcessor.INSTANCE;

    @Test(
            priority = 2,
            testName = "SABROWSECATEGORIES_01",
            description = "Verify Api was SUCCESSFULLY processed when being hit by a request",
            groups = "singleThreaded"
    )
    protected synchronized void spotifyApiTest_VerifyApiProcessedRequestWithGreenResponseCode() {
        Pair<BrowseCategoryProcessor, Response> dataRetrieved = browseCategoryProcessor.getBrowseCategoriesSuccessfully();
        browseCategoryProcessor.verifyBrowseCategoriesRequestResponseSttCode(dataRetrieved.getValue1());
    }

    @Test(
            priority = 3,
            testName = "SABROWSECATEGORIES_02",
            description = "Verify Api was UNSUCCESSFULLY processed when being hit by a request"
    )
    protected void spotifyApiTest_VerifyApiProcessedRequestWithBadResponseCode() {
        Pair<BrowseCategoryProcessor, Response> dataRetrieved = browseCategoryProcessor.getBrowseCategoriesUnsuccessfully();
        browseCategoryProcessor.verifyBrowseCategoriesRequestResponseSttCode(dataRetrieved.getValue1());
    }

    @Test(
            priority = 1,
            testName = "SABROWSECATEGORIES_03",
            description = ""
    )
    protected void spotifyApiTest_VerifyMusicTypeWasComprisedOfVietnameseMusic() {
        
    }
}
