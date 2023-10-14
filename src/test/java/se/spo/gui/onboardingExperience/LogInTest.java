package se.spo.gui.onboardingExperience;

import org.testng.annotations.*;
import se.business.HomePage;
import se.business.LogInPage;
import se.business.ProfilePage;
import se.commonHandler.baseService.BaseService;
import se.model.UserInformationModel;

public class LogInTest extends BaseService {

    //Authenticating user's access
    //Not inheriting BaseTest to test the log-in flows

    private LogInPage logInPage;
    private ProfilePage profPage;
    private HomePage homePage;
    private UserInformationModel usrModel;
    private Boolean wasSuccessfullyLoggedIn = false;

    //region Verify User had a successful log-in experience

    @Test(priority = 1)
    public void logInSuccessfully() {

        //Performing logging-in to Spotify
        logInPage.navigateToLogInPage().logInToSpotifyGateway(usrModel);

        //Verifying User has successfully logged-in
        profPage.verifyUserSuccessfullyLoggedIn();
        wasSuccessfullyLoggedIn = true;
    }

    //endregion

    //region Verify User has unsuccessfully logged-in with invalid credentials

    @Test(priority = 2)
    public void logInUnsuccessfullyWithBadPwd() {

        //Preparing an invalid password
        usrModel.setUserPassword(faker.produceCatchPhraseOfHowIMetYourMother() +
                                    faker.produceCharacterOfGameOfThrones() +
                                    faker.produceQuoteOfGameOfThrones());

        //Performing logging-in to Spotify
        logInPage.navigateToLogInPage().logInToSpotifyGateway(usrModel).verifyErrorMessagePresented();
    }

//    @Test(priority = 2)
    public void logInUnsuccessfullyWithBadUsrname() {

        //Preparing an invalid username
        usrModel.setUserEmail((faker.produceCharacterOfLordOfTheRings() +
                                faker.produceSpellOfHarryPotter()));

        //Performing logging-in to Spotify
        logInPage.navigateToLogInPage().logInToSpotifyGateway(usrModel).verifyErrorMessagePresented();
    }

//    @Test(priority = 2)
    public void logInUnccessfullyWithBadCredentials() {

        //Preparing invalid credentials
        usrModel.setUserEmail(faker.produceCharacterOfDragonBall());
        usrModel.setUserPassword(faker.produceMarvinQuoteOfHitchHikersGuideToTheGalaxy());

        //Performing logging-in to Spotify
        logInPage.navigateToLogInPage().logInToSpotifyGateway(usrModel).verifyErrorMessagePresented();
    }

    //endregion

    //region Test preparation and cleaning-up

    @BeforeMethod(alwaysRun = true)
    public void testPreparation() {
        usrModel = new UserInformationModel(gvuc.userEmail, gvuc.userPassword, gvuc.isRemembered);
        logInPage = new LogInPage(page);
        profPage = new ProfilePage(page);
        homePage = new HomePage(page);
    }

    @AfterMethod(alwaysRun = true)
    public void testCleaningUp() {
        if (wasSuccessfullyLoggedIn) {
            profPage.logOutOfSpotifyGateway();                  //User logged-off Spotify
            homePage.waitForLogInButtonPresented();
        }
    }

    //endregion
}
