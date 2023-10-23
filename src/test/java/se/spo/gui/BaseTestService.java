package se.spo.gui;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import se.business.BasePage;
import se.commonHandler.ConstantContainer.WaitConstant;
import se.commonHandler.baseService.BaseWaitHelper;
import se.infrastructure.PlaywrightFactory;
import se.utility.FakeDataUtil;
import se.utility.GlobalVariableUtil.BrowserConfiguration;
import se.utility.GlobalVariableUtil.UserCredential;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.PLUtil;

public class BaseTestService {

    /*

    This class contains all the relevant services in project
    that need to be initialized or handled

    */

    //region Introducing variables

    public FakeDataUtil faker;
    public PLUtil plUtil;
    public Environment gve;
    public static BrowserConfiguration gvbc;
    public UserCredential gvuc;

    public PlaywrightFactory playwrightFactory;
    public static Page page;

    public BasePage basePage;
    public BaseWaitHelper waitHelper;
    public WaitConstant waitConst;

    private ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<PlaywrightFactory> tlPlaywrightFactory = new ThreadLocal<>();

    public ThreadLocal<Page> _tlPage = new ThreadLocal<>();

    //endregion

    //region Introducing initialized services

    {
        //Thread handlers
//        tlPage = new ThreadLocal<>();
//        tlPlaywrightFactory = new ThreadLocal<>();

        //Global Environment fields
        gve = new Environment();
        gvbc = new BrowserConfiguration();
        gvuc = new UserCredential();

//        waitHelper = new BaseWaitHelper(page);
        waitHelper = new BaseWaitHelper(tlPage.get());

        //Utility files
        faker = new FakeDataUtil();
    }

    //endregion

    //region Initializing browser

    @BeforeClass
    public void assemblyPreparation() {
//        playwrightFactory = new PlaywrightFactory();
//        page = playwrightFactory.initializeInteractiveBrowser(gvbc.browserType, !gvbc.isHeadless);
//        basePage = new BasePage(page);

//        tlPage.set(playwrightFactory.initializeInteractiveBrowser(gvbc.browserType, !gvbc.isHeadless));

        setPlaywrightFactory();
        setPage();

        basePage = new BasePage(getPage());

//        page = tlPage.get();
    }

    //endregion

    public void setPage() {
        tlPage.set(getPlaywrightFactory().initializeInteractiveBrowser(gvbc.browserType, !gvbc.isHeadless));
    }

    public Page getPage() {

//        Page pagez = page;

        return tlPage.get();
//        return pagez;
    }

    public void setTlPage() {
        _tlPage.set(tlPage.get());
    }

    public Page getTlPage() {
        return _tlPage.get();
    }

    public void setPlaywrightFactory() {
        tlPlaywrightFactory.set(new PlaywrightFactory());
    }

    private static PlaywrightFactory getPlaywrightFactory() {
        return tlPlaywrightFactory.get();
    }
}
