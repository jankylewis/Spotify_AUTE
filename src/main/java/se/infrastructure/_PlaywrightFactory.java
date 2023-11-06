package se.infrastructure;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.utility.PLUtil.ViewportUtil;

public final class _PlaywrightFactory {

    //region Producing an interactive Playwright Page

    private static void produceInteractivePlaywrightPage() {

        PlaywrightManager.setPlaywright();

        switch (BrowserManager.BROWSER_TYPE) {
            case BrowserEnumeration._chromeBrowserType:
                BrowserManager.setChromeBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
            case BrowserEnumeration._firefoxBrowserType:
                BrowserManager.setFirefoxBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
            case BrowserEnumeration._webkitBrowserType:
                BrowserManager.setWebkitBrowserType();
                BrowserManager.setLaunchOptions();
                BrowserManager.setBrowser();
        }

        PlaywrightManager.setBrowserContext();

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
