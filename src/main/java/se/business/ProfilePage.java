package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.baseService.BaseVerification.IVerification;
import se.pageObject.ProfileObject;

public class ProfilePage extends ProfileObject implements IVerification {

    public ProfilePage(Page page) {
        super(page);
    }

    public void verifySpotifyLogoPresented() {
        waitHelper.waitForElementVisible(findLocator(BTN_SPOTIFY_LOGO), true);
        baseVerification.verifyElementVisible(findLocator(BTN_SPOTIFY_LOGO));

        verificationWentPassed();
    }

    public void verifyUserSuccessfullyLoggedIn() {
        waitHelper.waitForElementVisible(findLocator(BTN_PROFILE), true);
        baseVerification.verifyElementVisible(findLocator(BTN_PROFILE));

        verificationWentPassed();
    }

    public ProfilePage logOutOfSpotifyGateway() {
        baseUi.clickOnElement(findLocator(BTN_PROFILE));
        baseUi.clickOnElement(findLocator(BTN_LOG_OUT));
        return this;
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
}
