package se.business;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import se.commonHandler.baseService.waitHelper.PollingWaitHelper;
import se.commonHandler.constantHouse.uiConstant.MessageConstant;
import se.commonHandler.constantHouse.uiConstant.LocalPathConstant;
import se.commonHandler.constantHouse.uiConstant.WaitConstant;
import se.commonHandler.baseService.BaseUiAction;
import se.commonHandler.baseService.BaseVerification;
import se.commonHandler.baseService.waitHelper.BaseWaitHelper;
import se.pageObject.BaseObject;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.LoggingUtil;

public class BasePage extends BaseObject {

    //region Introducing fields

    protected Page page;
    protected BaseUiAction baseUi;
    protected BaseVerification baseVerification;
    protected BaseWaitHelper waitHelper;
    protected PollingWaitHelper pollingWaitHelper;
    protected WaitConstant waitConst;
    protected MessageConstant msgConst;
    protected LocalPathConstant localPathConst;
    protected Logger LOGGER;

    //region Retrieving global variables

    {
        msgConst = new MessageConstant();
        localPathConst = new LocalPathConstant();
        waitConst = new WaitConstant();
        LOGGER = LoggingUtil.TL_LOGGER.get();
    }

    //endregion

    //endregion

    public BasePage(Page page) {
        super(page);                                //Extending from BaseObject
        this.page = page;

        baseUi = new BaseUiAction(page);
        baseVerification = new BaseVerification(page);
        waitHelper = new BaseWaitHelper(page);
        pollingWaitHelper = new PollingWaitHelper(page);
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

    public Boolean waitForSkeletonLoadingToBeDetached(@Nullable Integer maxAttempts) {

        //Waiting for skeleton to be presented
        pollingWaitHelper.waitForElementToBeVisible(SECTION_SKELETON_LOADING, null);

        //Waiting for skeleton to be detached

        return pollingWaitHelper.waitForElementToBeDetachedWithPollings(SECTION_SKELETON_LOADING, maxAttempts);
    }
}
