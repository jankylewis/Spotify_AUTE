package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonObject extends BaseObject {

    public CommonObject(Page page) {
        super(page);
    }

    public Locator BTN_LOGO = page.locator("xpath=//a[img[@id = 'gh-logo']]");
    public Locator BTN_ACCOUNT_MENU = page.locator("xpath=//header//a[@data-encore-id='buttonPrimary']//following-sibling::button[@data-encore-id]");
    public Locator BTN_LOG_OUT = page.locator("xpath=//button[contains(@data-testid, 'logout')]");
}
