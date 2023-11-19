package se.business;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import se.commonHandler.baseService.BaseVerifier.IErrorVerification;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.pageObject.SignUpObject;
import se.utility.GlobalVariableUtil.Environment;

public class SignUpPage extends SignUpObject implements IVerification {

    public SignUpPage(Page page) {
        super(page);
    }

    public class SignUpAtFirstStep extends SignUpObjectAtFirstStep implements IErrorVerification {

        public  SignUpAtFirstStep(Page page) {
            super(page);
        }

        public SignUpAtFirstStep inputUsrEmail(String usrEmail) {
            baseUi.sendKeyToElement(findLocator(TXT_EMAIL), usrEmail);
            return this;
        }

        @Override
        public void verifyErrorMessagePresented() {

            Locator invalidEmailAddressLbl = findLocator(LBL_USERNAME_ERRMSG);

            waitHelper.waitForElementVisible(invalidEmailAddressLbl);
            baseVerifier.verifyStringsEqual(msgConst.LBL_INVALID_USERNAME, invalidEmailAddressLbl.textContent());

            verificationWentPassed();
        }
    }

    public class SignUpAtSecondStep extends SignUpObjectAtSecondStep implements IErrorVerification {

        public SignUpAtSecondStep(Page page) {
            super(page);
        }

        public SignUpAtSecondStep inputPassword(String usrPwd) {
            baseUi.sendKeyToElement(findLocator(TXT_PASSWORD), usrPwd);
            return this;
        }

        @Override
        public void verifyErrorMessagePresented() {

            Locator invalidPwdLbl = findLocator(LBL_PASSWORD_ERRMSG);

            waitHelper.waitForElementVisible(invalidPwdLbl);
            baseVerifier.verifyStringsEqual(msgConst.LBL_INVALID_PASSWORD, invalidPwdLbl.textContent());

            verificationWentPassed();
        }
    }

    public class SignUpAtThirdStep extends SignUpObjectAtThirdStep implements IErrorVerification {

        public SignUpAtThirdStep(Page page) {
            super(page);
        }

        public SignUpAtThirdStep inputDisplayedName(String displayedName) {
            baseUi.sendKeyToElement(findLocator(TXT_DISPLAYED_NAME), displayedName);
            return this;
        }

        public SignUpAtThirdStep selectGender(String gender) {

            //RBTN_GENDER might not be clickable => locating its parent
            baseUi.clickOnRadioButton(findLocator(RBTN_GENDER(gender) + "//following-sibling::label//span[2]"));

            return this;
        }

        public SignUpAtThirdStep inputBirthDate(int birthDate) {
            baseUi.sendKeyToElement(findLocator(TXT_BIRTHDATE), String.valueOf(birthDate));
            return this;
        }

        public SignUpAtThirdStep selectBirthMonth(String birthMonth) {
            baseUi.selectDropdown(findLocator(DDL_BIRTHMONTH), birthMonth);
            return this;
        }

        public SignUpAtThirdStep inputBirthYear(int birthYear) {
            baseUi.sendKeyToElement(findLocator(TXT_BIRTHYEAR), String.valueOf(birthYear));
            return this;
        }

        @Override
        public void verifyErrorMessagePresented() {
            Locator displayedNameRequiredMsgLbl = findLocator(LBL_DISPLAYED_NAME_ERRMSG);
            Locator dobRequiredMsgLbl = findLocator(LBL_BIRTHDATE_ERRMSG);
            Locator genderRequiredMsgLbl = findLocator(LBL_GENDER_ERRMSG);

            waitHelper.waitForElementVisible(displayedNameRequiredMsgLbl);

            baseVerifier.verifyStringsEqual(msgConst.LBL_REQUIRED_DISPLAYED_NAME, displayedNameRequiredMsgLbl.textContent());
            baseVerifier.verifyStringsEqual(msgConst.LBL_REQUIRED_DOB, dobRequiredMsgLbl.textContent());
            baseVerifier.verifyStringsEqual(msgConst.LBL_REQUIRED_GENDER, genderRequiredMsgLbl.textContent());

            verificationWentPassed();
        }
    }

    public SignUpPage clickOnNextBtn() {
        baseUi.clickOnElement(findLocator(BTN_NEXT), Double.valueOf(waitConst.MINTIMEOUT + 100));
        return this;
    }

    public SignUpPage navigateToSignUpPage() {

        baseUi.navigateToUrl(Environment.baseUrl +
                Environment.endPointLocalization +
                localPathConst.SIGN_UP_PATH);

        return this;
    }

    //region IVerification

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion
}
