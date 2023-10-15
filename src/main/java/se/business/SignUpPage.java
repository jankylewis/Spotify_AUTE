package se.business;

import com.microsoft.playwright.Page;
import se.commonHandler.baseService.BaseUIAction;

public class SignUpPage {

    private Page page;

    public SignUpPage(Page page) {
        this.page = page;
    }

    public SignUpPage navigateToSignUpPage() {

        page.navigate("https://www.spotify.com/vn-vi/signup");

        return this;
    }

}
