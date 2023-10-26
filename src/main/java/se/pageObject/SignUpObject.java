package se.pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpObject extends BaseObject {
    public SignUpObject(Page page) {
        super(page);
    }

    public Locator TXT_EMAIL = page.locator("//input[contains(@id, 'username')]");
    public Locator BTN_NEXT = page.locator("//button[contains(@data-encore-id, 'buttonPrimary')]");
}
