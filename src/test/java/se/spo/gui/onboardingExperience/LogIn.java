package se.spo.gui.onboardingExperience;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import se.business.LogInPage;
import se.business.ProfilePage;
import se.commonHandler.baseService.BaseService;
import se.commonHandler.baseService.BaseVerifier.IVerification;             //User-defined interface
import se.model.UserInformationModel;

public class LogIn extends BaseService implements IVerification {

    //Authenticating user's access
    //Not inheriting BaseTest to test the log-in flows

    private LogInPage logInPage;
    private ProfilePage profPage;
    private UserInformationModel usrModel;
    private Boolean wasSuccessfullyLoggedIn = false;

    @Test(priority = 1)
    public void logInSuccessfully() {

        //Performing logging-in to Spotify
        logInPage.navigateToLogInPage().logInToSpotifyGateway(usrModel);

        //Making verifications on Profile Page
        if (profPage.verifyUserSuccessfullyLoggedIn()) {
            wasSuccessfullyLoggedIn = true;
            verificationWentPassed();
        }
    }

    @Test(priority = 2)
    @Ignore
    public void logInUnsuccessfullyWithBadPwd() {
        verificationWentFailed();
    }

    @Test(priority = 2)
    @Ignore
    public void logInUnsuccessfullyWithBadUsrname() {
        verificationWentFailed();
    }

    @Test(priority = 2)
    @Ignore
    public void logInUnccessfullyWithBadCredentials() {
        verificationWentFailed();
    }

    @BeforeMethod()
    public void preparingTest() {
        usrModel = new UserInformationModel(gvuc.userEmail, gvuc.userPassword, gvuc.isRemembered);
        logInPage = new LogInPage(page);
        profPage = new ProfilePage(page);
    }

    @AfterMethod
    public void cleaningTest() {
        if (wasSuccessfullyLoggedIn) {
            basePage.logOutOfSpotifyGateway();          //User logged-off Spotify
        }
    }

    //region IVerification goes here

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion
}
