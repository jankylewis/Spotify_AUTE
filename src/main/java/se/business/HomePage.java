package se.business;

import com.microsoft.playwright.Page;
import se.pageObject.HomeObject;

public class HomePage extends HomeObject {

    public HomePage(Page page) {
        super(page);
    }

    public HomePage waitForLogInButtonPresented() {
        waitHelper.waitForElementVisible(findLocator(BTN_LOG_IN), false);
        return this;
    }

    public HomePage waitForInstallAppButtonPresented() {
        waitHelper.waitForElementVisible(findLocator(BTN_INSTALL_APP));
        return this;
    }
}
