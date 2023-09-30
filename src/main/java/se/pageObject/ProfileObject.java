package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfileObject extends BaseObject {

    public ProfileObject(Page page) {
        super(page);
    }

    public Locator BTN_SPOTIFY_LOGO = page.locator("xpath=//a[@data-tracking and not(@data-ga-action) and contains(@class, 'mh-header-primary')]");
}
