package se.commonHandler.baseService;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BaseVerifier {

    private Page page;

    public BaseVerifier(Page page) {
        this.page = page;
    }

    public void verifyElementVisible(Locator expLocator) {
         expLocator.isVisible();
    }

    public boolean verifyStringsEqual(String expStr, String actStr) {

        if (expStr.trim().toLowerCase() == actStr.trim().toLowerCase()) {
            return true;
        } else {
            return false;
        }
    }

    public interface IVerification {
        void verificationWentPassed();

        void verificationWentFailed();
    }
}
