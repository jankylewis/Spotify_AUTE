package se.business;

import com.microsoft.playwright.Page;
import se.pageObject.ProfileObject;

public class ProfilePage extends BasePage {
    private ProfileObject profObject;

    public ProfilePage(Page page) {
        super(page);

        profObject = new ProfileObject(page);
    }

    public boolean verifySpotifyLogoPresented() {
        waitHelper.waitForElementVisible(profObject.BTN_SPOTIFY_LOGO, true);
        return baseVerifier.verifyElementVisible(profObject.BTN_SPOTIFY_LOGO);
    }

    public boolean verifyUserSuccessfullyLoggedIn() {

        return false;
    }
}
