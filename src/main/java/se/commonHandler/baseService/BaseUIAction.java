package se.commonHandler.baseService;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.constantEnumeration.ActionConstant;
import se.commonHandler.constantEnumeration.WaitConstant;

import java.awt.*;

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

    {
       waitConst = new WaitConstant();
    }

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
        waitHelper.waitForElementVisible(expLocator);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts)));
    }

    public void clickOnElement(@NotNull ElementHandle expLocator) {
        expLocator.click();
    }

    public void clickOnElementByForcing(Locator expLocator) {
        waitHelper.waitForElementVisible(expLocator);

        expLocator.click(actionConst.clickOpts
                .setForce(true));
    }

    public void clickOnElementByForcing(Locator expLocator, Double delayTimeOut) {
        waitHelper.waitForElementVisible(expLocator);

        expLocator.click(actionConst.clickOpts
                .setForce(true)
                .setDelay(delayTimeOut));
    }

    public void clickOnElement(Locator expLocator, boolean isLongWaitUsed) {
        waitHelper.waitForElementVisible(expLocator, isLongWaitUsed);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts)));
    }

    public void clickOnElement(Locator expLocator, Double delayTimeOut) {           //Giving a hard-coded delay
        waitHelper.waitForElementVisible(expLocator, false);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts))
                .setDelay(delayTimeOut));
    }

    public void clickOnElement(Locator expLocator,
                               Double delayTimeOut,
                               boolean isLongWaitUsed) {                           //Giving a hard-coded delay

        waitHelper.waitForElementVisible(expLocator, isLongWaitUsed);

        expLocator.click(actionConst.clickOpts
                .setForce(actionConst.getClearByForced(actionConst.clickOpts))
                .setNoWaitAfter(actionConst.getNoWaitAfter(actionConst.clickOpts))
                .setDelay(delayTimeOut));
    }

    public void clickOnRadioButton(Locator expLocator) {
        waitHelper.waitForElementVisible(expLocator);

        expLocator.check();
    }

    public void selectDropdown(Locator expLocator, String expOption) {
        waitHelper.waitForElementVisible(expLocator);

        expLocator.selectOption(expOption);
    }

    public void hoverElement(Locator expLocator) {
        waitHelper.waitForElementVisible(expLocator, false);
        expLocator.hover();
    }

    public void clickOnElement(@NotNull Locator expLocator, int expCounter) {
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

    public void pressKey(String expKey) {
        page.keyboard().press(expKey);
    }
}
