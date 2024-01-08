package se.commonHandler.baseService;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;

public class BaseVerifier {

    private Page page;

    public BaseVerifier(Page page) {
        this.page = page;
    }

    public boolean verifyElementVisible(@NotNull Locator expLocator) {
        return expLocator.isVisible();
    }

    public boolean verifyStringEquality(@NotNull String expStr, @NotNull String actStr) {

        if (expStr.toLowerCase().trim().equals(actStr.toLowerCase().trim())) {
            return true;
        } else {
            throw new AssertionError(
                    "Expected string [" + expStr + "] did not match actual string [" + actStr + "]");
        }
    }

    public Boolean verifyExpectedStringContained(@NotNull String expStr, @NotNull String actStr) {
        if (actStr.trim().toLowerCase().contains(expStr.trim().toLowerCase())) {
            return true;
        } else {
            throw new AssertionError(
                    "Actual string [" + actStr + "] did not contain expected string [" + expStr + "]");
        }
    }

    //region Verification services

    public interface IErrorVerification {
        void verifyErrorMessagePresented();
    }

    public interface IVerification {
        void verificationWentPassed();      //Using this abstract void to assert a PASSED script

        void verificationWentFailed();      //Using this abstract void to assert a script went FAILED (being used if needed)
    }

    //endregion
}
