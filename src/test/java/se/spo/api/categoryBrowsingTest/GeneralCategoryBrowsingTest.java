package se.spo.api.categoryBrowsingTest;

import io.restassured.response.Response;
import org.javatuples.Pair;
import org.testng.annotations.Test;
import se.requestProcessor.categoryProcessor.GeneralCategoryProcessor;
import se.spo.api.BaseApiTestService;

public class GeneralCategoryBrowsingTest extends BaseApiTestService {

    private GeneralCategoryProcessor browseCategoryProcessor = GeneralCategoryProcessor.INSTANCE;

    @Test(
            priority = 2,
            testName = "SABROWSECATEGORIES_01",
            description = "Verify Api was SUCCESSFULLY processed when being hit by a request",
            groups = "singleThreaded"
    )
    protected void spotifyApiTest_VerifyApiProcessedRequestWithGreenResponseCode() {
        Pair<GeneralCategoryProcessor, Response> dataRetrieved = browseCategoryProcessor.getBrowseCategoriesSuccessfully();
        browseCategoryProcessor.verifyBrowseCategoriesRequestResponseSttCode(dataRetrieved.getValue1());
    }

    @Test(
            priority = 3,
            testName = "SABROWSECATEGORIES_02",
            description = "Verify Api was UNSUCCESSFULLY processed when being hit by a request"
    )
    protected void spotifyApiTest_VerifyApiProcessedRequestWithBadResponseCode() {
        Pair<GeneralCategoryProcessor, Response> dataRetrieved = browseCategoryProcessor.getBrowseCategoriesUnsuccessfully();
        browseCategoryProcessor.verifyBrowseCategoriesRequestResponseSttCode(dataRetrieved.getValue1());
    }
}
