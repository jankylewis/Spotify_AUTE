package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BaseObject {

    protected Page page;
    private Locator foundLocator;

    public BaseObject(Page page) {
        this.page = page;
    }

    public final String BTN_LOGO = "xpath=//a[img[@id = 'gh-logo']]";
    public final String BTN_ACCOUNT_MENU = "xpath=//header//a[@data-encore-id='buttonPrimary']//following-sibling::button[@data-encore-id]";
    public final String BTN_LOG_OUT = "xpath=//button[contains(@data-testid, 'logout')]z";

    //region Locating locators service

    public Locator findLocator(String expLocator) {

        int timesOfRetrying = 3;

        do {
            foundLocator = page.locator(expLocator);
            timesOfRetrying--;
        }
        while (timesOfRetrying > 0);

        return foundLocator;
    }

    //endregion

}
