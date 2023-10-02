package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfileObject extends BaseObject {

    public ProfileObject(Page page) {
        super(page);
    }

    public Locator BTN_SPOTIFY_LOGO = page.locator("xpath=//a[@data-tracking and not(@data-ga-action) and contains(@class, 'mh-header-primary')]");
    public Locator BTN_PROFILE = page.locator("xpath=//button[contains(@class, 'mh-header-primary') and contains(@aria-controls, 'profile')]");
    public Locator BTN_LOG_OUT= page.locator("xpath=//div[contains(@id, 'profileMenu')]//a[contains(@class, 'subtle')]");
}
