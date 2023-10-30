package se.business;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.ConstantContainer.LocalPathConstant;
import se.commonHandler.ConstantContainer.MessageConstant;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.model.UserInformationModel;
import se.pageObject.LogInObject;

public class LogInPage extends BasePage implements IVerification {

    //region Initializing log-in objects

    private LogInObject logInObj;

    public LogInPage(Page page) {
        super(page);

        logInObj = new LogInObject(page);
    }

    //endregion

    //region Taking UI actions

    public LogInPage logInToSpotifyGateway(@NotNull UserInformationModel usrModel) {

        //Providing fields
        baseUi.sendKeyToElement(logInObj.TXT_EMAIL, usrModel.getUserEmail());
        baseUi.sendKeyToElement(logInObj.TXT_PASSWORD, usrModel.getUserPassword());

        //Handling User's auto-login
        baseUi.clickOnElementWithSelected(logInObj.TG_REMEMBER_ME.locator("//following::span/span[not(@data-encore-id)]"), usrModel.getUserRemembered());

        //Signing-in
        baseUi.clickOnElementWithDelay(logInObj.BTN_LOG_IN, Double.valueOf(waitConst.TIMEOUT1S));

        return this;
    }

    public LogInPage navigateToLogInPage() {
        baseUi.navigateToUrl(gvE.baseUrl + gvE.endPointLocalization + LocalPathConstant.LOGINPATH);
        return this;
    }

    //endregion

    //region Making verifications on successful log-in

    public void verifyAccountMenuPresented() {
        waitHelper.waitForElementVisible(commonObject.BTN_ACCOUNT_MENU, true);
        baseVerifier.verifyElementVisible(commonObject.BTN_ACCOUNT_MENU);
    }

    public void verifyErrorMessagePresented() {
        waitHelper.waitForElementVisible(logInObj.LBL_INVALID_CREDENTIALS, false);
        baseVerifier.verifyStringsEqual(MessageConstant.LBL_INVALID_CREDENTIALS, logInObj.LBL_INVALID_CREDENTIALS.textContent());

        verificationWentPassed();
    }

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
