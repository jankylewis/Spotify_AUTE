package se.pageObject;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BaseObject {

    protected Page page;
    private Locator foundLocator;
    private List<ElementHandle> listOfFoundLocators;

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

    public List<ElementHandle> findListOfLocator(String expLocator) {

        listOfFoundLocators = new ArrayList<>();
        int timesOfRetrying = 3;

        do {
            if (timesOfRetrying == 1) {
                throw new PlaywrightException("The desired element has not been found!");
            }

            listOfFoundLocators = page.querySelectorAll(expLocator + "ass");

            if (listOfFoundLocators.isEmpty()) {
                timesOfRetrying--;
            }
            else {
                break;
            }
        }
        while (timesOfRetrying > 0);

        return listOfFoundLocators;
    }

    //endregion

}
