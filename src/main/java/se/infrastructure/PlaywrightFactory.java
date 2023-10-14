package se.infrastructure;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;

import java.awt.*;

public class PlaywrightFactory {

    //region Introducing playwright objects

    public static BrowserContext browserContext;
    protected static Playwright playwright;
    public static Browser browser;
    protected static BrowserType browserType;
    protected static LaunchOptions launchOptions;
    protected static Page page;

    //endregion

    //region Initializing browser

    //region Maximizing window

//    private static Browser.NewContextOptions produceNewContextOptions() {
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        return new Browser.NewContextOptions().setViewportSize(screenSize.width, screenSize.height);
//    }

    //endregion

    protected static BrowserContext produceBrowserContext() {
//        return browserContext = browser.newContext(produceNewContextOptions());
        return browserContext = browser.newContext();
    }

    protected static Page producePlaywrightPage() {
        return page = browserContext.newPage();
    }

    protected static LaunchOptions produceLaunchOptions(String browserName, boolean isHeaded) {

        //Specifically handling for chrome browser type
        return launchOptions = browserName.equalsIgnoreCase(BrowserManagement._chromeBrowserType) ? new LaunchOptions().setChannel(browserName).setHeadless(!isHeaded) : new LaunchOptions().setHeadless(!isHeaded);
    }

    protected static Playwright producePlaywright() {
        return playwright = Playwright.create();
    }

    private static BrowserType produceChromeBrowserType() {
        return browserType = BrowserManagement.chromeBrowserType;
    }

    private static BrowserType produceFirefoxBrowserType() {
        return browserType = BrowserManagement.firefoxBrowserType;
    }

    private static BrowserType produceWebkitBrowserType() {
        return browserType = BrowserManagement.webkitBrowserType;
    }

    //region Launching a new browser

    private static Page produceInteractivePlwPage(String browserName, boolean isHeaded) throws IllegalArgumentException {

        producePlaywright();

        switch (browserName.toLowerCase()) {
            case BrowserManagement._chromiumBrowserType:
                browser = produceChromeBrowserType().launch(produceLaunchOptions(browserName, isHeaded));
                break;
            case BrowserManagement._chromeBrowserType:
                browser = produceChromeBrowserType().launch(produceLaunchOptions(browserName, isHeaded));
                break;
            case BrowserManagement._firefoxBrowserType:
                browser = produceFirefoxBrowserType().launch(produceLaunchOptions(browserName, isHeaded));
                break;
            case BrowserManagement._webkitBrowserType:
                browser = produceWebkitBrowserType().launch(produceLaunchOptions(browserName, isHeaded));
                break;
            default:
                throw new IllegalArgumentException("Your desired browser was invalid, please provide another browser type!");
        }

        produceBrowserContext();

        producePlaywrightPage();

        return page;
    }

    //endregion

    public Page initializeBrowser(String browserName, boolean isHeaded) {
        produceInteractivePlwPage(browserName, isHeaded);
        return page;
    }

    //endregion

}
