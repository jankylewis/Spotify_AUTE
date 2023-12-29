package se.commonHandler.baseService;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.Page.WaitForURLOptions;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.Locator.WaitForOptions;

import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.constantHouse.uiConstant.WaitConstant;

public class BaseWaitHelper {

    private Page page;
    private WaitConstant waitConst;

    public BaseWaitHelper(Page page) {
        this.page = page;
    }

    {
        waitConst = new WaitConstant();
    }

    //region Introducing vars

    protected NavigateOptions navOpts = new NavigateOptions();
    protected WaitForURLOptions waitUrlOpts = new WaitForURLOptions();

    private WaitForSelectorOptions waitForSelectorOptions = new WaitForSelectorOptions();
    private WaitForOptions waitForOptions = new WaitForOptions();

    //endregion

    //region Wait section goes here

    public void waitForElementVisible(@NotNull Locator expLocator) {

        //Waiting for locator to be visible
        expLocator.waitFor(waitForOptions.setState(WaitForSelectorState.VISIBLE));
    }

    public void waitForElementAttached(@NotNull Locator expLocator) {

        //Waiting for locator to be attached on DOM
        expLocator.waitFor(waitForOptions.setState(WaitForSelectorState.ATTACHED));
    }

    public void waitForElementVisible(@NotNull Pair<ElementHandle, String> pairOfElement) {

        //Waiting for locator to be visible with time-out
        pairOfElement.getValue0().waitForSelector(pairOfElement.getValue1(),
                new ElementHandle.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void waitForElementVisible(@NotNull Locator expLocator, boolean isLongWait) {

        //Time-out settings
        int selTimeOut = isLongWait == true ? waitConst.MAXTIMEOUT : waitConst.TIMEOUT3S;

        //Waiting for locator to be visible with time-out
        expLocator.waitFor(waitForOptions.setState(WaitForSelectorState.VISIBLE).setTimeout(selTimeOut));
    }

    //endregion

    //region Hard-coded waiting

    public static void forcedWait(int millisecondsToWait) {
        try {
            Thread.sleep(millisecondsToWait);
        } catch (Exception ex) {
            throw new RuntimeException("Found an unexpected exception: "
                    + ex.getCause() + " - " + ex.getMessage());
        }
    }

    //endregion
}
