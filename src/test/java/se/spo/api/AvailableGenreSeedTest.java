package se.spo.api;

import io.restassured.response.Response;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;
import se.requestProcessor.AvailableGenreSeedProcessor;
import se.spo.api.testDataProvider.TestDataFactory;
import se.spo.api.testDataProvider.TestDataFactory.AvailableGenreSeedDataProvider;

import java.io.IOException;
import java.util.*;

@Test(singleThreaded = true)        //This test class will be single-threadedly executed
public class AvailableGenreSeedTest extends BaseApiTestService {

    private AvailableGenreSeedProcessor availableGenreSeedProcessor = AvailableGenreSeedProcessor.INSTANCE;

    @Test(
            priority = 2,
            testName = "SAAVAILABLEGENRESEED_01",
            description = "Verify Gospel type was included in the response when User made a request"
    )
    protected synchronized void spotifyApiTest_VerifyGospelTypeWasPresentedInTheResponse() {
        final String genreType = "Gospel";
        Pair<AvailableGenreSeedProcessor, Response> dataResponded = availableGenreSeedProcessor.getAvailableGenreSeed();
        availableGenreSeedProcessor.verifyGenreWasPresentedInTheListOfAvailableGenreSeeds(dataResponded.getValue1(), genreType);
    }

    @Test(
            priority = 1,
            testName = "SAAVAILABLEGENRESEED_02",
            description = "Verify that the responded list of genre seeds shall match accurately the expected list",
            dataProvider = "AvailableGenreSeedsProvider",
            dataProviderClass = AvailableGenreSeedDataProvider.class
    )
    protected synchronized void spotifyApiTest_VerifyRespondedListMatchedAccuratelyExpectedList(
            @NotNull Hashtable availableGenreSeedsHashTable
    ) {
        //Making a request headed toward getting available genre seeds API
        Pair<AvailableGenreSeedProcessor, Response> dataResponded = availableGenreSeedProcessor.getAvailableGenreSeed();

        availableGenreSeedProcessor.verifyTheExpectedListMatchedAccuratelyTheRespondedList(
                dataResponded.getValue1(),
                availableGenreSeedsHashTable
        );
    }

    @Test(
            priority = 2,
            testName = "SAAVAILABLEGENRESEED_03",
            description = "Verify that several available genre seeds will be comprised of the responded list",
            dataProvider = "AvailableGenreSeedsProvider",
            dataProviderClass = AvailableGenreSeedDataProvider.class
    )
    protected synchronized void spotifyApiTest_VerifySeveralAvailableGenreSeedsWillBeListed(
            @NotNull Hashtable availableGenreSeedsHashTable
    ) {
        //Making a request headed toward getting available genre seeds API
        Pair<AvailableGenreSeedProcessor, Response> dataResponded = availableGenreSeedProcessor.getAvailableGenreSeed();

        //Verifying the several genres listed in the responded list of genres
        availableGenreSeedProcessor.verifySeveralAvailableGenreSeedsListedInRespondedList(
                dataResponded.getValue1(), availableGenreSeedsHashTable
        );
    }

    @Test(
            priority = 3,
            testName = "SAAVAILABLEGENRESEED_04",
            description = "Verify that the invalid tokens shall not be authenticated",
            dataProviderClass = TestDataFactory.class,
            dataProvider = "InvalidTokensProvider"
    )
    protected synchronized void spotifyApiTest_VerifyTheInvalidTokensWereNotAuthenticated(
            @NotNull List<String> invalidTokens) {

        int numberOfTokensProcessed = invalidTokens.size();
        int tokenIdx = 0;

        do {

            //Making a request headed toward getting available genre seeds API with dummy tokens
            Pair<AvailableGenreSeedProcessor, Response> dataResponded =
                    availableGenreSeedProcessor.getAvailableGenreSeed(invalidTokens.get(tokenIdx));

            dataResponded.getValue0().verifyInvalidTokenErrorMessageResponded(dataResponded.getValue1());
            tokenIdx++;

        } while (tokenIdx < numberOfTokensProcessed);
    }

    @Test(
            priority = 3,
            testName = "SAAVAILABLEGENRESEED_05",
            description = "Verify that the expired tokens shall not be authenticated",
            dataProviderClass = TestDataFactory.class,
            dataProvider = "ExpiredTokensProvider"
    )
    protected synchronized void spotifyApiTest_VerifyTheExpiredTokensWereNotAuthenticated(
            @NotNull Pair<String, String> expiredTokens) {

        //Making a request headed toward getting available genre seeds API with an expired token
        Pair<AvailableGenreSeedProcessor, Response> dataResponded =
                availableGenreSeedProcessor.getAvailableGenreSeed(expiredTokens.getValue1());

        dataResponded.getValue0()
                .verifyExpiredTokenErrorMessageResponded(dataResponded.getValue1(), expiredTokens.getValue0());
    }

    @Test(
            priority = 3,
            testName = "SAAVAILABLEGENRESEED_06",
            description = "Verify that Api responded a certain error if there was no token provided"
    )
    protected synchronized void spotifyApiTest_VerifyApiThrewErrorIfNoTokenProvided() throws IOException {

        //Generating an empty HashSet
        TestDataFactory.INSTANCE.prepareModifiableTokensWithCsv(
                new Object() {}.getClass().getEnclosingMethod());

        Pair<AvailableGenreSeedProcessor, Response> dataResponded =
                availableGenreSeedProcessor.getAvailableGenreSeedWithBasicRequest();

        dataResponded.getValue0()
                .verifyNoneOfTokenProvidedErrorMessageResponded(dataResponded.getValue1());
    }

    @Test(
            priority = 3,
            testName = "SAAVAILABLEGENRESEED_07",
            description = "Verify that Api rejected when User requested other authentication services"
    )
    protected synchronized void spotifyApiTest_VerifyApiRejectedIfUserRequestedAnotherAuthenticationService()
            throws IOException {

        Collection<Pair<String, String>> unmodifiableTokens =
                Collections.unmodifiableCollection((Collection<Pair<String, String>>)
                                TestDataFactory.INSTANCE.
                                        prepareModifiableTokensWithCsv(new Object() {}.getClass().getEnclosingMethod()));

        for (int idx = 0; idx < unmodifiableTokens.size(); idx++) {
            Pair<AvailableGenreSeedProcessor, Response> dataResponded =
                    availableGenreSeedProcessor.getAvailableGenreSeed("");
            dataResponded.getValue0()
                    .verifyUnsupportedAuthenticationServiceErrorMessageResponded(
                            unmodifiableTokens.stream().toList().get(idx), dataResponded.getValue1());
        }
    }

    //To keep repo tracked
}
