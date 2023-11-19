package se.business;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.model.UserInformationModel;
import se.pageObject.LogInObject;
import se.utility.GlobalVariableUtil.Environment;

public class LogInPage extends LogInObject implements IVerification {

    //region Initializing log-in objects

    public LogInPage(Page page) {
        super(page);
    }

    //endregion

    //region Taking UI actions

    public LogInPage logInToSpotifyGateway(@NotNull UserInformationModel usrModel) {

        //Providing fields
        baseUi.sendKeyToElement(findLocator(TXT_EMAIL), usrModel.getUserEmail());
        baseUi.sendKeyToElement(findLocator(TXT_PASSWORD), usrModel.getUserPassword());

        //Handling User's auto-login
        baseUi.clickOnElementWithSelected(
                findLocator(TG_REMEMBER_ME).locator("//following::span/span[not(@data-encore-id)]"),
                usrModel.getUserRemembered()
        );

        //Signing-in
        baseUi.clickOnElement(findLocator(BTN_LOG_IN), Double.valueOf(waitConst.TIMEOUT1S));

        return this;
    }

    public LogInPage navigateToLogInPage() {

        baseUi.navigateToUrl(Environment.baseUrl +
                Environment.endPointLocalization +
                localPathConst.LOG_IN_PATH);

        return this;
    }

    //endregion

    //region Making verifications on successful log-in

    public void verifyAccountMenuPresented() {
        waitHelper.waitForElementVisible(findLocator(BTN_ACCOUNT_MENU), true);
        baseVerifier.verifyElementVisible(findLocator(BTN_ACCOUNT_MENU));
    }

    public void verifyErrorMessagePresented() {
        Locator invalidCredentialsLbl = findLocator(LBL_INVALID_CREDENTIALS);

        waitHelper.waitForElementVisible(invalidCredentialsLbl, false);
        baseVerifier.verifyStringsEqual(msgConst.LBL_INVALID_CREDENTIALS, invalidCredentialsLbl.textContent());

        verificationWentPassed();
    }

    //region IVerifications

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion

    //endregion
}
