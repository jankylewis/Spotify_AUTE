package se.spo.gui.searchingExperience.ForTesting;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import se.commonHandler.baseService.BaseService;
import se.infrastructure.PlaywrightFactory;
import se.utility.PLUtil;

public class BaseTL {

    protected Page page;

    private Browser br;
    private BrowserContext brC;
    private Page _page;
    private Playwright pl;

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
//        return page = getPage();
        return page = _page;
    }

    @BeforeTest
    public void pretest() {
//        tlPlaywright.set(Playwright.create());
//        tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
//
//        tlBrowserContext.set(getBrowser().newContext());
//        tlPage.set(getBrowserContext().newPage());

//        pl = Playwright.create();
//        br = pl.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
////
//        brC = br.newContext();
//
//        _page = brC.newPage();
        _page = new PlaywrightFactory().initializeInteractiveBrowser("chrome", true);

//        getPage().navigate("https://www.spotify.com/vn-vi/signup");


        threadHandler=  new PLUtil.ThreadHandler();
    }
}

