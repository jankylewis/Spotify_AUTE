package se.spo.gui;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import se.business.BasePage;
import se.business.LogInPage;
import se.infrastructure.PlaywrightFactory;
import se.model.UserInformationModel;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.GlobalVariableUtil.BrowserConfiguration;
import se.utility.GlobalVariableUtil.UserCredential;

public class BaseTest {

    //region Introducing fields

    protected PlaywrightFactory playwrightFactory;
    protected Page page;
    protected BasePage basePage;
    protected LogInPage logInPage;

    protected final Environment gvE;
    protected final BrowserConfiguration gvBC;
    protected final UserCredential gvUC;

    //endregion

    //region Retrieving global variables

    {
        gvE = new Environment();
        gvBC = new BrowserConfiguration();
        gvUC = new UserCredential();
    }

    //endregion

    @BeforeSuite
    public void testPreparation() {

        //region Initializing the base services

        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initializeBrowser(gvBC.browserType, !gvBC.isHeadless);
        basePage = new BasePage(page);

        //endregion
        logInPage = new LogInPage(page);

        logInPage.navigateToLogInPage()                         //Logging in to Spotify gateway
                .logInToSpotifyGateway(new UserInformationModel(gvUC.userEmail, gvUC.userPassword, gvUC.isRemembered))
                .navigateToBaseUrl();

        Assert.assertTrue(logInPage.verifyAccountMenuPresented());
    }

    @AfterSuite
    public void testCleaning() {
        basePage.logOutOfSpotifyGateway();                      //Logging out of Spotify gateway
    }
}
