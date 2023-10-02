package se.business;

import com.microsoft.playwright.Page;
import se.pageObject.HomeObject;

public class HomePage extends BasePage {

    private HomeObject homeObj;
    public HomePage(Page page) {
        super(page);

        homeObj = new HomeObject(page);
    }

    public void waitForLogInButtonPresented() {
        waitHelper.waitForElementVisible(homeObj.BTN_LOG_IN, false);
    }
}
