package se.pageObject;

import com.microsoft.playwright.Page;
import se.business.BasePage;

public class LogInObject extends BasePage {

    protected LogInObject(Page page) {
        super(page);
    }

    protected final String TXT_EMAIL = "id=login-username";
    protected final String TXT_PASSWORD = "id=login-password";
    protected final String TG_REMEMBER_ME = "xpath=//input[@id = 'login-remember']";
    protected final String BTN_LOG_IN = "id=login-button";
    protected final String LBL_INVALID_CREDENTIALS ="xpath=.//div[contains(@data-encore-id, 'banner')]//span";
}
