package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.pageObject.ProfileObject;

public class ProfilePage extends BasePage implements IVerification {
    private ProfileObject profObject;

    public ProfilePage(Page page) {
        super(page);

        profObject = new ProfileObject(page);
    }

    public void verifySpotifyLogoPresented() {
        waitHelper.waitForElementVisible(profObject.BTN_SPOTIFY_LOGO, true);
        baseVerifier.verifyElementVisible(profObject.BTN_SPOTIFY_LOGO);
    }

    public void verifyUserSuccessfullyLoggedIn() {
        waitHelper.waitForElementVisible(profObject.BTN_PROFILE, true);
        baseVerifier.verifyElementVisible(profObject.BTN_PROFILE);

        verificationWentPassed();
    }

    public ProfilePage logOutOfSpotifyGateway() {
        baseUi.clickOnElement(profObject.BTN_PROFILE);
        baseUi.clickOnElement(profObject.BTN_LOG_OUT);
        return this;
    }

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }
}
