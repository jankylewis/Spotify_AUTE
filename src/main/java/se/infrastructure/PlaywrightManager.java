package se.infrastructure;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import se.utility.GlobalVariableUtil.ScriptConfiguration;

import java.nio.file.Paths;
import java.util.Random;

public final class PlaywrightManager {            //This service generates Playwright Interactive Page

    //region Thread Manager > Introducing Playwright objects

    private static final Boolean RECORDED = ScriptConfiguration.RECORDED;
    private static final ThreadLocal<Page> TL_PAGE = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> TL_BROWSER_CONTEXT = new ThreadLocal<>();

    //Initially generating a new Playwright instance
    private static final ThreadLocal<Playwright> TL_PLAYWRIGHT = ThreadLocal.withInitial(Playwright::create);

    //endregion

    //region Initializing Page

    static void setPage() {
        TL_PAGE.set(getBrowserContext().newPage());
    }

    static Page getPage() {
        return TL_PAGE.get();
    }

    //endregion

    //region Initializing BrowserContext

    static void setBrowserContext() {

        if (!RECORDED) {
            TL_BROWSER_CONTEXT.set(
                    BrowserManager.getBrowser().newContext());
        } else {
            TL_BROWSER_CONTEXT.set(
                    BrowserManager.getBrowser().newContext(
                            new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./src/test/java/se/spo/gui/testRecordings/recorded_" + new Random().nextInt(1, 9000000)))
                    ));
        }
    }

    private static BrowserContext getBrowserContext() {
        return TL_BROWSER_CONTEXT.get();
    }

    //endregion

    //region Getting Playwright instance

    static Playwright getPlaywright() {
        return TL_PLAYWRIGHT.get();
    }

    //endregion

    //region Cleaning all opened Threads

    public static void disposeThreads() {
        getBrowserContext().close();
        getPage().close();
        getPlaywright().close();
        TL_BROWSER_CONTEXT.remove();
        TL_PAGE.remove();
        TL_PLAYWRIGHT.remove();
    }

    //endregion

}
