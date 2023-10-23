package se.spo.gui;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import se.business.LogInPage;
import se.business.ProfilePage;
import se.commonHandler.baseService.BaseService;
import se.model.UserInformationModel;

public class BaseTest extends BaseService {

    // region Introducing fields

    protected LogInPage logInPage;
    protected ProfilePage profPage;
    protected UserInformationModel usrModel;

    // endregion

    //region Initializing instances

    {
//        logInPage = new LogInPage(page);
//        profPage = new ProfilePage(page);

        logInPage = new LogInPage(getPage());
        profPage = new ProfilePage(getPage());
    }

    //endregion

    @BeforeSuite
    public void testPreparation() {
        logInPage.navigateToLogInPage()             //Logging in to Spotify gateway
                .logInToSpotifyGateway(usrModel = new UserInformationModel(gvuc.userEmail, gvuc.userPassword, gvuc.isRemembered));

        profPage.verifySpotifyLogoPresented();

        basePage.navigateToBaseUrl();
    }

    @AfterSuite
    public void testCleaning() {
        basePage.logOutOfSpotifyGateway();          //Logging out of Spotify gateway
    }
}
