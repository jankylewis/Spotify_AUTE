package se.pageObject;

import com.microsoft.playwright.Page;
import se.business.BasePage;

public class LogInObject extends BasePage {

    public LogInObject(Page page) {
        super(page);
    }

    public final String TXT_EMAIL = "id=login-username";
    public final String TXT_PASSWORD = "id=login-password";
    public final String TG_REMEMBER_ME = "xpath=//input[@id = 'login-remember']";
    public final String BTN_LOG_IN = "id=login-button";
    public final String LBL_INVALID_CREDENTIALS ="xpath=.//div[contains(@data-encore-id, 'banner')]//span";
}
