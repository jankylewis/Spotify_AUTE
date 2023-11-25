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

    protected final String BTN_LOGO = "xpath=//a[img[@id = 'gh-logo']]";
    protected final String BTN_ACCOUNT_MENU = "xpath=//header//a[@data-encore-id='buttonPrimary']//following-sibling::button[@data-encore-id]";
    protected final String BTN_LOG_OUT = "xpath=//button[contains(@data-testid, 'logout')]z";

    //region Locating locators service

    protected Locator findLocator(String expLocator) {

        int timesOfRetrying = 3;

        do {
            if (timesOfRetrying == 1) {
                throw new NoSuchElementException("The desired element has not been found!");
            }

            foundLocator = page.locator(expLocator);
            try {
                foundLocator.isVisible();
                break;
            }
            catch (PlaywrightException plwEx) {
                if (!(plwEx.getMessage().contains("DOMException"))) {
                    throw plwEx;
                }
            }
        }
        while (timesOfRetrying-- > 0);

        return foundLocator;
    }

    protected ElementHandle findFirstLocatorVisible(String expLocator) {

        listOfFoundLocators = new ArrayList<>();
        int timesOfRetrying = 3;

        do {
            if (timesOfRetrying == 1) {
                throw new NoSuchElementException("The desired element has not been found!");
            }

            listOfFoundLocators = page.querySelectorAll(expLocator);

            if (listOfFoundLocators.isEmpty()) {
                timesOfRetrying--;
            }
            else {
                break;
            }
        }
        while (timesOfRetrying > 0);

        return listOfFoundLocators.stream()             //Getting the FIRST displayed element
                .filter(ElementHandle::isVisible)
                .toList()
                .get(0);
    }

    protected List<ElementHandle> findListOfLocator(String expLocator) {

        listOfFoundLocators = new ArrayList<>();
        int timesOfRetrying = 3;

        do {
            if (timesOfRetrying == 1) {
                throw new NoSuchElementException("The desired element has not been found!");
            }

            listOfFoundLocators = page.querySelectorAll(expLocator);

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