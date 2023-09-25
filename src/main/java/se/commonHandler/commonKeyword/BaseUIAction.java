package se.commonHandler.commonKeyword;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.ConstantContainer.ActionConstant;
import se.commonHandler.ConstantContainer.WaitConstant;

public class BaseUIAction {

    // region Introducing objects

    public Page page;
    private BaseWaitHelper waitHelper;
    private WaitConstant waitConst;
    private ActionConstant actionConst;

    // endregion

    // region Introducing constructor

    public BaseUIAction(Page page) {
        this.page = page;
        waitHelper = new BaseWaitHelper(page);
    }

    // endregion
    public void navigateToUrl(String expUrl) {
        page.navigate(expUrl, waitHelper.navOpts.setWaitUntil(waitConst.DOMCONTENTWAITER));
    }

    public void clearAllValues(@NotNull Locator expLocator) {
        expLocator.clear(actionConst.clOpts
                .setForce(actionConst.getClearByForced(actionConst.clOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clOpts)));
    }

    public void sendKeyToElement(Locator expLocator, String expText) {
        waitHelper.waitForElementVisible(expLocator, false);

        clearAllValues(expLocator);

        expLocator.fill(expText, actionConst.fillOpts
                .setForce(actionConst.getClearByForced(actionConst.fillOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.fillOpts)));
    }

    public void clickOnElement(Locator expLocator) {
        waitHelper.waitForElementVisible(expLocator, false);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts)));
    }

    public void clickOnElementWithDelay(Locator expLocator, Double delayTimeOut) {           //Giving a hard-coded delay
        waitHelper.waitForElementVisible(expLocator, false);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts))
                .setDelay(delayTimeOut));
    }

    public void hoverElement(Locator expLocator) {
        waitHelper.waitForElementVisible(expLocator, false);
        expLocator.hover();
    }

    public void clickOnElementWithRetrying(@NotNull Locator expLocator, int expCounter) {
        waitHelper.waitForElementVisible(expLocator, false);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts))
                .setClickCount(actionConst.getClickCount(actionConst.clickOpts, expCounter)));
    }

    public void clickOnElementWithSelected(Locator expLocator, boolean isChecked) {
        waitHelper.waitForElementVisible(expLocator, false);

        if (expLocator.isChecked() != isChecked) {
            expLocator.click(actionConst.clickOpts
                    .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                    .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts)));
        }
    }
}
