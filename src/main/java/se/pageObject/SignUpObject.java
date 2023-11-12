package se.pageObject;

import com.microsoft.playwright.Page;
import se.business.BasePage;

public class SignUpObject extends BasePage {
    public SignUpObject(Page page) {
        super(page);
    }

    public final String TXT_EMAIL = "//input[contains(@id, 'username')]";
    public final String BTN_NEXT = "//button[contains(@data-encore-id, 'buttonPrimary')]";
}
