package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomeObject extends BaseObject {

    public HomeObject(Page page) {
        super(page);
    }

    public Locator LBL_MADEFORUSERNAME = page.locator("\"//section[contains(@aria-label, 'Made For Jan')]//a[contains(text(), 'Made For Jan')]\"");

}
