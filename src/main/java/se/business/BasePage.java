package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.ConstantContainer.WaitConstant;
import se.commonHandler.baseService.BaseUIAction;
import se.commonHandler.baseService.BaseVerifier;
import se.commonHandler.baseService.BaseWaitHelper;
import se.pageObject.BaseObject;
import se.pageObject.CommonObject;
import se.utility.GlobalVariableUtil.BrowserConfiguration;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.GlobalVariableUtil.UserCredential;

public class BasePage extends BaseObject {

    //region Introducing fields

    protected Environment gvE;
    protected UserCredential gvUC;
    protected BrowserConfiguration gvBC;
    protected Page page;                                    //Initializing page at first
    protected BaseUIAction baseUi;
    protected BaseVerifier baseVerifier;
    protected BaseWaitHelper waitHelper;
    protected CommonObject commonObject;
    protected WaitConstant waitConst;

    //region Retrieving global variables

    {
        gvE = new Environment();
        gvBC = new BrowserConfiguration();
        gvUC = new UserCredential();
    }

    //endregion

    //endregion

    public BasePage(Page page) {
        super(page);                                //Extending from BaseObject
        this.page = page;

        baseUi = new BaseUIAction(page);
        baseVerifier = new BaseVerifier(page);
        waitHelper = new BaseWaitHelper(page);

        commonObject = new CommonObject(page);
    }

    public BasePage navigateToBaseUrl() {
        baseUi.navigateToUrl(gvE.baseUrl);
        return this;
    }

    public BasePage logOutOfSpotifyGateway() {
        baseUi.clickOnElement(commonObject.BTN_ACCOUNT_MENU);
        baseUi.clickOnElement(commonObject.BTN_LOG_OUT);
        return this;
    }
}
