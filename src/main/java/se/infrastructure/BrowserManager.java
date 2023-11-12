package se.infrastructure;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import se.utility.GlobalVariableUtil.BrowserConfiguration;

public final class BrowserManager {         //This service manages Browser-related objects

    //region Introducing objects

    static final String BROWSER_TYPE = BrowserConfiguration.BROWSER_TYPE;
    static final Boolean HEADLESS = BrowserConfiguration.HEADLESS;

    //endregion

    //region Thread Manager > Introducing Playwright objects

    private static final ThreadLocal<Browser> TL_BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserType> TL_BROWSER_TYPE = new ThreadLocal<>();
    private static final ThreadLocal<LaunchOptions> TL_LAUNCH_OPTIONS = new ThreadLocal<>();

    //endregion

    //region Initializing Browser

    static void setBrowser() {
        TL_BROWSER.set(getBrowserType().launch(getLaunchOptions()));
    }

    static Browser getBrowser() {
        return TL_BROWSER.get();
    }

    //endregion

    //region Initializing LaunchOptions

    static void setLaunchOptions() {
        TL_LAUNCH_OPTIONS.set(
                new LaunchOptions().setHeadless(HEADLESS).setChannel(BROWSER_TYPE));
    }

    private static LaunchOptions getLaunchOptions() {
        return TL_LAUNCH_OPTIONS.get();
    }

    //endregion

    //region Initializing BrowserType

    static void setChromeBrowserType() {
        TL_BROWSER_TYPE.set(PlaywrightManager.getPlaywright().chromium());
    }

    static void setFirefoxBrowserType() {
        TL_BROWSER_TYPE.set(PlaywrightManager.getPlaywright().firefox());
    }

    static void setWebkitBrowserType() {
        TL_BROWSER_TYPE.set(PlaywrightManager.getPlaywright().webkit());
    }

    private static BrowserType getBrowserType() {
        return TL_BROWSER_TYPE.get();
    }

    //endregion

}
