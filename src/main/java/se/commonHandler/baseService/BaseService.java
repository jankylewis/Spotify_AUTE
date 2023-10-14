package se.commonHandler.baseService;

import com.microsoft.playwright.Page;
import se.business.BasePage;
import se.commonHandler.ConstantContainer.WaitConstant;
import se.infrastructure.PlaywrightFactory;
import se.utility.FakeDataUtil;
import se.utility.GlobalVariableUtil.BrowserConfiguration;
import se.utility.GlobalVariableUtil.UserCredential;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.PLUtil;

public class BaseService {

    /*

    This class contains all the relevant services in project
    that need to be initialized or handled

    */

    //region Introducing variables

    public FakeDataUtil faker;
    public PLUtil plUtil;
    public Environment gve;
    public BrowserConfiguration gvbc;
    public UserCredential gvuc;

    public PlaywrightFactory playwrightFactory;
    public Page page;

    public BasePage basePage;
    public BaseWaitHelper waitHelper;
    public WaitConstant waitConst;

    //endregion

    //region Introducing initialized services

    {
        gve = new Environment();
        gvbc = new BrowserConfiguration();
        gvuc = new UserCredential();

        waitHelper = new BaseWaitHelper(page);

        faker = new FakeDataUtil();
    }

    //endregion

    //region Initializing browser

    public BaseService() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initializeInteractiveBrowser(gvbc.browserType, !gvbc.isHeadless);
        basePage = new BasePage(page);
    }

    //endregion

}
