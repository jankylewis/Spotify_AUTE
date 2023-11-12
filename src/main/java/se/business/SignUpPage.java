package se.business;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.model.UserInformationModel;
import se.pageObject.SignUpObject;

public class SignUpPage extends SignUpObject {

    public SignUpPage(Page page) {
        super(page);
    }

    public SignUpPage signUp(@NotNull UserInformationModel usrModel) {
        baseUi.sendKeyToElement(findLocator(TXT_EMAIL), usrModel.getUserEmail());
        baseUi.clickOnElement(findLocator(BTN_NEXT));
        return this;
    }

    public SignUpPage navigateToSignUpPage() {
        baseUi.navigateToUrl(gvE.baseUrl + gvE.endPointLocalization + localPathConst.SIGN_UP_PATH);
        return this;
    }

}
