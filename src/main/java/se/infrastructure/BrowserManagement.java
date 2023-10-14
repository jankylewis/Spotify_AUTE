package se.infrastructure;

import com.microsoft.playwright.BrowserType;

public class BrowserManagement {

    //region Introducing browser types

//    protected static BrowserType chromeBrowserType = PlaywrightFactory.playwright.chromium();
//    protected static BrowserType firefoxBrowserType = PlaywrightFactory.playwright.firefox();
//    protected static BrowserType webkitBrowserType = PlaywrightFactory.playwright.webkit();
    protected static BrowserType chromeBrowserType = PlaywrightFactory.getPlaywright().chromium();
    protected static BrowserType firefoxBrowserType = PlaywrightFactory.getPlaywright().firefox();
    protected static BrowserType webkitBrowserType = PlaywrightFactory.getPlaywright().webkit();

    //These browser type will be retrieved from settings files
    protected static final String _chromiumBrowserType = "chromium";
    protected static final String _chromeBrowserType = "chrome";
    protected static final String _firefoxBrowserType = "firefox";
    protected static final String _webkitBrowserType = "webkit";

    //endregion

}
