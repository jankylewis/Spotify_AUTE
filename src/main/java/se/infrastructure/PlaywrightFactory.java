package se.infrastructure;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotAnimations;
import org.jetbrains.annotations.NotNull;
import se.utility.JUtil.ViewportUtil;

import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Random;

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

    public static byte[] takeScreenshots() {
        return PlaywrightManager.getPage().screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get("./src/test/java/se/spo/gui/testScreenshots/captured_" + new Random().nextInt(1, 9000000) + ".jpeg"))
                        .setAnimations(ScreenshotAnimations.ALLOW)
                        .setQuality(100));
    }
}
