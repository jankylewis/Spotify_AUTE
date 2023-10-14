package se.infrastructure;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;
import org.jetbrains.annotations.NotNull;

public class PlaywrightFactory {

    //region Introducing objects

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> tlBrowserType = new ThreadLocal<>();
    private static ThreadLocal<LaunchOptions> tlLaunchOptions = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    protected static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();

    //endregion

    //region Initializing browser

    //Maximizing window
//    private static Browser.NewContextOptions produceNewContextOptions() {
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        return new Browser.NewContextOptions().setViewportSize(screenSize.width, screenSize.height);
//    }


    //region Thread management

    //region Initializing Playwright

    private static void setPlaywright() {
        tlPlaywright.set(Playwright.create());
    }

    protected static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    //endregion

    //region Initializing BrowserType

    private static void setChromeBrowserType() {
        tlBrowserType.set(BrowserManagement.chromeBrowserType);
    }

    private static void setFirefoxBrowserType() {
        tlBrowserType.set(BrowserManagement.firefoxBrowserType);
    }

    private static void setWebkitBrowserType() {
        tlBrowserType.set(BrowserManagement.webkitBrowserType);
    }

    private static BrowserType getBrowserType() {
        return tlBrowserType.get();
    }

    //endregion

    //region Initializing LaunchOptions

    private static void setLaunchOptions(@NotNull String browserName, boolean isHeaded) {
        tlLaunchOptions.set(browserName.equalsIgnoreCase(BrowserManagement._chromeBrowserType) ?
                            new LaunchOptions().setChannel(browserName).setHeadless(!isHeaded) :
                            new LaunchOptions().setHeadless(!isHeaded));
    }

    private static LaunchOptions getLaunchOptions() {
        return tlLaunchOptions.get();
    }

    //endregion

    //region Initializing Browser

    private static void setBrowser() {
        tlBrowser.set(getBrowserType().launch(getLaunchOptions()));
    }

    private static Browser getBrowser() {
        return tlBrowser.get();
    }

    //endregion

    //region Initializing BrowserContext

    private static void setBrowserContext() {
        tlBrowserContext.set(getBrowser().newContext());
    }

    private static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    //endregion

    //region Producing an interactive Playwright Page

    private static void produceInteractivePlaywrightPage(@NotNull String browserName, boolean isHeaded) {

        //Producing Playwright
        setPlaywright();

        //Normalizing browserName
        browserName = browserName.toLowerCase().trim();

        switch (browserName) {
            case BrowserManagement._chromeBrowserType:
                setChromeBrowserType();                             //Producing BrowserType with Chrome browser
                setLaunchOptions(browserName, isHeaded);            //Producing LaunchOptions with Chrome browser
                setBrowser();                                       //Producing Browser
                break;
            case BrowserManagement._firefoxBrowserType:
                setFirefoxBrowserType();                            //Producing BrowserType with Firefox browser
                setLaunchOptions(browserName, isHeaded);            //Producing LaunchOptions with Firefox browser
                setBrowser();                                       //Producing Browser
                break;
            case BrowserManagement._webkitBrowserType:
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

        //Generating an interactive Page
        return getPage();
    }

    //endregion

    //region Initializing Page

    private static void setPage() {
        tlPage.set(getBrowserContext().newPage());
    }

    private static Page getPage() {
        return tlPage.get();
    }

    //endregion

    //endregion

}
