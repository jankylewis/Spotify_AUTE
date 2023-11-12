package se.commonHandler.baseService;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;

public class BaseVerifier {

    private Page page;

    public BaseVerifier(Page page) {
        this.page = page;
    }

    public void verifyElementVisible(@NotNull Locator expLocator) {
        expLocator.isVisible();
    }

    public boolean verifyStringsEqual(@NotNull String expStr, @NotNull String actStr) {

        if (expStr.trim().toLowerCase() == actStr.trim().toLowerCase()) {
            return true;
        } else {
            return false;
        }
    }

    //region IVerfications

    public interface IVerification {
        void verificationWentPassed();

        void verificationWentFailed();
    }

    //endregion
}
