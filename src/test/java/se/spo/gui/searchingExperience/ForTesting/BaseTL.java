package se.spo.gui.searchingExperience.ForTesting;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;
import se.commonHandler.baseService.BaseService;
import se.utility.PLUtil;

public class BaseTL {

    protected Page page;
    private ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    protected PLUtil.ThreadHandler threadHandler;

    private Browser getBrowser() {
        return tlBrowser.get();
    }

    private BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    private Page getPage() {
        return tlPage.get();
    }

    private Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    protected Page getMPage() {
        return page = getPage();
    }

    @BeforeTest
    public void pretest() {
        tlPlaywright.set(Playwright.create());
        tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());

//        getPage().navigate("https://www.spotify.com/vn-vi/signup");


        threadHandler=  new PLUtil.ThreadHandler();
    }
}
