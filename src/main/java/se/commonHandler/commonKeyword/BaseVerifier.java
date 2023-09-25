package se.commonHandler.commonKeyword;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BaseVerifier {

    private Page page;

    public BaseVerifier(Page page) {
        this.page = page;
    }

    public boolean verifyElementVisible(Locator expLocator) {
        return expLocator.isVisible();
    }
}
