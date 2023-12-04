package se.spo.gui.onboardingExperience;

import org.jetbrains.annotations.NotNull;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.HomePage;
import se.business.LogInPage;
import se.business.ProfilePage;
import se.model.UserInformationModel;
import se.spo.gui.BaseTestService;
import se.utility.GlobalVariableUtil.UserCredential;

public class LogInTest extends BaseTestService {

    //region Introducing objects

    private LogInPage logInPage;
    private ProfilePage profilePage;
    private HomePage homePage;
    @NotNull
    private UserInformationModel usrModel;
    private Boolean wasSuccessfullyLoggedIn;

    //endregion

    //region Verifying User's Log-in experience

    @Test(priority = 1,
            testName = "SWLOGIN_01: Verify User has successfully logged-in to the Spotify stream",
            invocationCount = 1)
    protected void spotifyUiTest_verifyUserHasSuccessfullyLoggedIn() {
        LOGGER.info("Step: Performing logging-in to Spotify");
        logInPage.logInToSpotifyGateway(usrModel);

        LOGGER.info("Step: Verifying User has successfully logged-in");
        profilePage.verifyUserSuccessfullyLoggedIn();

        wasSuccessfullyLoggedIn = true;
    }

    @Test(priority = 1,
            testName = "SWLOGIN_03: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using an invalid email then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadUsername() {

        LOGGER.info("Step: Preparing an invalid-and-lengthy email");
        usrModel.setUserEmail(faker.produceSpellOfHarryPotter());

        LOGGER.info("Step: Performing logging-in to Spotify");
        LOGGER.info("Step: Verifying that an ERROR came up!");
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    @Test(priority = 1,
            testName = "SWLOGIN_02: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using an invalid password then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadPassword() {

        LOGGER.info("Step: Preparing an invalid-and-lengthy password");
        usrModel.setUserPassword(
                faker.produceCatchPhraseOfHowIMetYourMother() +
                        faker.produceCharacterOfGameOfThrones() +
                        faker.produceQuoteOfGameOfThrones() +
                        faker.produceCharacterOfLordOfTheRings() +
                        faker.produceMarvinQuoteOfHitchHikersGuideToTheGalaxy() +
                        faker.produceCharacterOfDragonBall()
        );

        LOGGER.info("Step: Performing logging-in to Spotify");
        LOGGER.info("Step: Verifying that an ERROR came up!");
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    @Test(priority = 1,
            testName = "SWLOGIN_04: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using improper credentials then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadCredentials() {

        LOGGER.info("Step: Preparing an invalid-and-lengthy email");
        usrModel.setUserEmail(faker.produceCharacterOfGameOfThrones());

        LOGGER.info("Step: Performing logging-in to Spotify");
        LOGGER.info("Step: Verifying that an ERROR came up!");
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    //endregion

    //region Test preparation and cleaning

    @BeforeMethod
    protected void testPreparation() {

        LOGGER.info("Preparing a User Information Model");
        usrModel = new UserInformationModel(UserCredential.USER_EMAIL,
                UserCredential.USER_PASSWORD,
                UserCredential.REMEMBERED);

        logInPage = new LogInPage(page);
        profilePage = new ProfilePage(page);
        homePage = new HomePage(page);

        LOGGER.info("Navigating to Log-in Page");
        logInPage.navigateToLogInPage();
    }

    @AfterMethod
    protected void testCleaning() {

        LOGGER.info("Logging-out of Spotify");
        if (wasSuccessfullyLoggedIn != null) {
            profilePage.logOutOfSpotifyGateway();
            homePage.waitForLogInButtonPresented();
        }
    }

    //endregion

}
