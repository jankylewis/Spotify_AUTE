package se.business;

import com.microsoft.playwright.Page;
import se.pageObject.HomeObject;

public class HomePage extends HomeObject {

    public HomePage(Page page) {
        super(page);
    }

    public void waitForLogInButtonPresented() {
        waitHelper.waitForElementVisible(findLocator(BTN_LOG_IN), false);
    }
}
