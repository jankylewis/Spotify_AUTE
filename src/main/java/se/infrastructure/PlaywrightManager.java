package se.infrastructure;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class PlaywrightManager {            //This service generates Playwright Interactive Page

    //region Thread Manager > Introducing Playwright objects

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
        TL_BROWSER_CONTEXT.set(BrowserManager.getBrowser().newContext());
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

}
