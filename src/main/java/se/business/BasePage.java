package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.constantHouse.uiConstant.MessageConstant;
import se.commonHandler.constantHouse.uiConstant.LocalPathConstant;
import se.commonHandler.constantHouse.uiConstant.WaitConstant;
import se.commonHandler.baseService.BaseUiAction;
import se.commonHandler.baseService.BaseVerification;
import se.commonHandler.baseService.BaseWaitHelper;
import se.pageObject.BaseObject;
import se.utility.GlobalVariableUtil.Environment;

public class BasePage extends BaseObject {

    //region Introducing fields

    protected Page page;
    protected BaseUiAction baseUi;
    protected BaseVerification baseVerification;
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

        baseUi = new BaseUiAction(page);
        baseVerification = new BaseVerification(page);
        waitHelper = new BaseWaitHelper(page);
    }

    public BasePage navigateToBaseUrl() {
        baseUi.navigateToUrl(Environment.BASE_URL);
        return this;
    }

    public BasePage logOutOfSpotifyGateway() {
        baseUi.clickOnElement(findLocator(BTN_ACCOUNT_MENU));
        baseUi.clickOnElement(findLocator(BTN_LOG_OUT));
        return this;
    }
}
