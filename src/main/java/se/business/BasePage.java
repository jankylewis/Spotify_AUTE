package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.constantEnumeration.MessageConstant;
import se.commonHandler.constantEnumeration.LocalPathConstant;
import se.commonHandler.constantEnumeration.WaitConstant;
import se.commonHandler.baseService.BaseUIAction;
import se.commonHandler.baseService.BaseVerifier;
import se.commonHandler.baseService.BaseWaitHelper;
import se.pageObject.BaseObject;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.StringUtil;

public class BasePage extends BaseObject {

    //region Introducing fields

    protected Page page;
    protected BaseUIAction baseUi;
    protected BaseVerifier baseVerifier;
    protected BaseWaitHelper waitHelper;
    protected WaitConstant waitConst;
    protected MessageConstant msgConst;
    protected LocalPathConstant localPathConst;

    //region Retrieving global variables

    {
        msgConst = new MessageConstant();
        localPathConst = new LocalPathConstant();
        waitConst = new WaitConstant();
    }

    //endregion

    //endregion

    public BasePage(Page page) {
        super(page);                                //Extending from BaseObject
        this.page = page;

        baseUi = new BaseUIAction(page);
        baseVerifier = new BaseVerifier(page);
        waitHelper = new BaseWaitHelper(page);
    }

    public BasePage navigateToBaseUrl() {
        baseUi.navigateToUrl(Environment.baseUrl);
        return this;
    }

    public BasePage logOutOfSpotifyGateway() {
        baseUi.clickOnElement(findLocator(BTN_ACCOUNT_MENU));
        baseUi.clickOnElement(findLocator(BTN_LOG_OUT));
        return this;
    }
}
