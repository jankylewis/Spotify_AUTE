package se.infrastructure;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.jetbrains.annotations.NotNull;
import se.utility.PLUtil.ViewportUtil;

/*
    Plw Factory is a service used for initializing browser (called an Interactive Page)
    for each test
 */

public final class PlaywrightFactory {

    //region Introducing objects

    private ViewportUtil viewportUtil = new ViewportUtil();

    //endregion

    //region Introducing objects utilizing Thread Management

    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserType> tlBrowserType = new ThreadLocal<>();
    private static final ThreadLocal<LaunchOptions> tlLaunchOptions = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    protected static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    //endregion

    //region Playwright Page > Thread Management

    //region Initializing Playwright

    private void setPlaywright() {
        tlPlaywright.set(Playwright.create());
    }

    protected Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    //endregion

    //region Initializing BrowserType

    private void setChromeBrowserType() {
        tlBrowserType.set(getPlaywright().chromium());
    }

    private void setFirefoxBrowserType() {
        tlBrowserType.set(getPlaywright().firefox());
    }

    private void setWebkitBrowserType() {
        tlBrowserType.set(getPlaywright().webkit());
    }

    private BrowserType getBrowserType() {
        return tlBrowserType.get();
    }

    //endregion

    //region Initializing LaunchOptions

    private void setLaunchOptions(@NotNull String browserName, boolean isHeaded) {
        tlLaunchOptions.set(browserName.equalsIgnoreCase(BrowserEnumeration._chromeBrowserType) ? new LaunchOptions().setChannel(browserName).setHeadless(!isHeaded) : new LaunchOptions().setHeadless(!isHeaded));
    }

    private LaunchOptions getLaunchOptions() {
        return tlLaunchOptions.get();
    }

    //endregion

    //region Initializing Browser

    private void setBrowser() {
        tlBrowser.set(getBrowserType().launch(getLaunchOptions()));
    }

    private Browser getBrowser() {
        return tlBrowser.get();
    }

    //endregion

    //region Initializing BrowserContext

    private void setBrowserContext() {
        tlBrowserContext.set(getBrowser().newContext());
    }

    private BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    //endregion

    //region Producing an interactive Playwright Page

    private void produceInteractivePlaywrightPage(@NotNull String browserName, boolean isHeaded) {

        //Producing Playwright
        setPlaywright();

        //Normalizing browserName
        browserName = browserName.toLowerCase().trim();

        switch (browserName) {
            case BrowserEnumeration._chromeBrowserType:
                setChromeBrowserType();                             //Producing BrowserType with Chrome browser
                setLaunchOptions(browserName, isHeaded);            //Producing LaunchOptions with Chrome browser
                setBrowser();                                       //Producing Browser
                break;
            case BrowserEnumeration._firefoxBrowserType:
                setFirefoxBrowserType();                            //Producing BrowserType with Firefox browser
                setLaunchOptions(browserName, isHeaded);            //Producing LaunchOptions with Firefox browser
                setBrowser();                                       //Producing Browser
                break;
            case BrowserEnumeration._webkitBrowserType:
                setWebkitBrowserType();                             //Producing BrowserType with Webkit browser
                setLaunchOptions(browserName, isHeaded);            //Producing LaunchOptions with Webkit browser
                setBrowser();                                       //Producing Browser
                break;
        }

        //Producing BrowserContext
        setBrowserContext();

        //Producing Page
        setPage();
    }

    public Page initializeInteractiveBrowser(String browserName, boolean isHeaded) {

        //Ushering a Page
        produceInteractivePlaywrightPage(browserName, isHeaded);

        //Generating an Interactive Playwright Page (was maximized)
        return viewportUtil.exaggerateViewport(getPage());
    }

    //endregion

    //region Initializing Page

    private void setPage() {
        tlPage.set(getBrowserContext().newPage());
    }

    private Page getPage() {
        return tlPage.get();
    }

    //endregion

    //endregion

}
