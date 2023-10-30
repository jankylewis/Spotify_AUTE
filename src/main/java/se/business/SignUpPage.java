package se.business;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.model.UserInformationModel;
import se.pageObject.SignUpObject;

public class SignUpPage extends BasePage {

    private Page page;
    private SignUpObject signUpObj;

    public SignUpPage(Page page) {
        super(page);

        signUpObj = new SignUpObject(page);
    }

    public SignUpPage signUp(@NotNull UserInformationModel usrModel) {

        baseUi.sendKeyToElement(signUpObj.TXT_EMAIL, usrModel.getUserEmail());
        baseUi.clickOnElement(signUpObj.BTN_NEXT);

        return this;
    }

    public SignUpPage navigateToSignUpPage() {

        baseUi.navigateToUrl("https://www.spotify.com/vn-vi/signup");

        return this;
    }

}
