package se.commonHandler.commonKeyword;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.Page.WaitForURLOptions;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.Locator.WaitForOptions;

import se.commonHandler.ConstantContainer.WaitConstant;


public class BaseWaitHelper {

    private Page page;

    public BaseWaitHelper(Page page) {
        this.page = page;
    }

    //region Introducing vars

    protected NavigateOptions navOpts = new NavigateOptions();
    protected WaitForURLOptions waitUrlOpts = new WaitForURLOptions();

    private WaitForSelectorOptions waitForSelectorOptions = new WaitForSelectorOptions();
    private WaitForOptions waitForOptions = new WaitForOptions();

    //endregion

    //region Wait section goes here

    public void waitForElementVisible(Locator expLocator, boolean isLongWait) {

        //Time-out settings
        int selTimeOut = isLongWait == true ? WaitConstant.MAXTIMEOUT : WaitConstant.TIMEOUT3S;

        //Waiting for locator to be visible with time-out
        expLocator.waitFor(waitForOptions.setState(WaitForSelectorState.VISIBLE).setTimeout(selTimeOut));
    }

    //endregion

    //region Hard-coded waiting

    public void forceWait(int millisecondsToWait) {
        try {
            Thread.sleep(millisecondsToWait);
        } catch (Exception ex) {
            throw new RuntimeException("Found an unexpected exception: " + ex.getCause() + " - " + ex.getMessage());
        }
    }

    //endregion
}
