package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogInObject extends BaseObject {

    public LogInObject(Page page) {
        super(page);
    }

    public Locator TXT_EMAIL = page.locator("id=login-username");
    public Locator TXT_PASSWORD = page.locator("id=login-password");
    public Locator TG_REMEMBER_ME = page.locator("xpath=//input[@id = 'login-remember']");;
    public Locator BTN_LOG_IN = page.locator("id=login-button");
}
