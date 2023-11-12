package se.infrastructure;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.utility.PLUtil.ViewportUtil;

import java.security.InvalidParameterException;

public final class PlaywrightFactory {

    //region Producing an interactive Playwright Page

    private static void produceInteractivePlaywrightPage() {

        //Categorizing Browser Type
        switch (BrowserManager.BROWSER_TYPE) {
            case BrowserEnumeration._chromeBrowserType:
            case BrowserEnumeration._chromiumBrowserType:
                BrowserManager.setChromeBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
                break;
            case BrowserEnumeration._firefoxBrowserType:
                BrowserManager.setFirefoxBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
                break;
            case BrowserEnumeration._webkitBrowserType:
                BrowserManager.setWebkitBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
                break;
            default:
                throw new InvalidParameterException("\rYour desired browser was invalid!\r");
        }

        //Creating a new Browser Context
        PlaywrightManager.setBrowserContext();

        //Creating a new Interactive Page from Browser Context
        PlaywrightManager.setPage();
    }

    public static @NotNull Page produceInteractiveBrowser() {

        //Ushering a Page
        produceInteractivePlaywrightPage();

        //Generating an Interactive Playwright Page (was maximized)
        return ViewportUtil.exaggerateViewport(PlaywrightManager.getPage());
    }

    //endregion

}
