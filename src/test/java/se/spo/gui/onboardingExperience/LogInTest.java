package se.spo.gui.onboardingExperience;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.HomePage;
import se.business.LogInPage;
import se.business.ProfilePage;
import se.model.UserInformationModel;
import se.spo.gui.BaseTestService;

public class LogInTest extends BaseTestService {

    //region Introducing objects

    private LogInPage logInPage;
    private ProfilePage profilePage;
    private HomePage homePage;
    private UserInformationModel usrModel;
    private Boolean wasSuccessfullyLoggedIn;

    //endregion

    //region Verifying User's log-in experience

    @Test(priority = 1,
            testName = "SW01: Verify User has successfully logged-in to the Spotify stream",
            invocationCount = 1)
    protected void spotifyUiTest_verifyUserHasSuccessfullyLoggedIn() {

        //Performing logging-in to Spotify
        logInPage.logInToSpotifyGateway(usrModel);

        //Verifying User has successfully logged-in
        profilePage.verifyUserSuccessfullyLoggedIn();

        wasSuccessfullyLoggedIn = true;
    }

    @Test(priority = 1,
            testName = "SW02: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using an invalid password then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadPassword() {

        //Preparing an invalid-and-lengthy password
        usrModel.setUserPassword(
                faker.produceCatchPhraseOfHowIMetYourMother() +
                        faker.produceCharacterOfGameOfThrones() +
                        faker.produceQuoteOfGameOfThrones() +
                        faker.produceCharacterOfLordOfTheRings() +
                        faker.produceMarvinQuoteOfHitchHikersGuideToTheGalaxy() +
                        faker.produceCharacterOfDragonBall()
        );

        //Performing logging-in to Spotify
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    @Test(priority = 1,
            testName = "SW03: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using an invalid email then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadUsername() {

        //Preparing an invalid-and-lengthy email
        usrModel.setUserEmail(faker.produceSpellOfHarryPotter());

        //Performing logging-in to Spotify
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    @Test(priority = 1,
            testName = "SW04: Verify User has not successfully logged-in to the Spotify stream" +
                    "when using improper credentials then got an error message")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullyLoggedInWithBadCredentials() {

        //Preparing an invalid-and-lengthy email
        usrModel.setUserEmail(faker.produceCharacterOfGameOfThrones());

        //Performing logging-in to Spotify
        logInPage.logInToSpotifyGateway(usrModel)
                .verifyErrorMessagePresented();
    }

    //endregion

    //region Test preparation and cleaning

    @BeforeMethod
    protected void testPreparation() {

        usrModel = new UserInformationModel(gvuc.userEmail,
                gvuc.userPassword,
                gvuc.isRemembered);

        logInPage = new LogInPage(page);
        profilePage = new ProfilePage(page);
        homePage = new HomePage(page);

        logInPage.navigateToLogInPage();
    }

    @AfterMethod
    protected void testCleaning() {

        //Logging-out of Spotify
        if (wasSuccessfullyLoggedIn != null) {
            profilePage.logOutOfSpotifyGateway();
            homePage.waitForLogInButtonPresented();
        }
    }

    //endregion

}
