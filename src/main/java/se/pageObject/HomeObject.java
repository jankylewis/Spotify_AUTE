package se.pageObject;

import com.microsoft.playwright.Page;
import se.business.BasePage;

public class HomeObject extends BasePage {

    public HomeObject(Page page) {
        super(page);
    }

    public final String LBL_MADEFORUSERNAME = "xpath=//section[contains(@aria-label, 'Made For Jan')]//a[contains(text(), 'Made For Jan')]";
    public final String BTN_LOG_IN = "xpath=//button[contains(@data-testid, 'login-button')]";
}
