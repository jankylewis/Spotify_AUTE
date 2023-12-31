package se.pageObject;

import com.microsoft.playwright.Page;
import se.business.BasePage;

public class ProfileObject extends BasePage {

    protected ProfileObject(Page page) {
        super(page);
    }

    protected final String BTN_SPOTIFY_LOGO = "xpath=//a[@data-tracking and not(@data-ga-action) and contains(@class, 'mh-header-primary')]";
    protected final String BTN_PROFILE = "xpath=//button[contains(@class, 'mh-header-primary') and contains(@aria-controls, 'profile')]";
    protected final String BTN_LOG_OUT= "xpath=//div[contains(@id, 'profileMenu')]//a[contains(@class, 'subtle')]";
}
