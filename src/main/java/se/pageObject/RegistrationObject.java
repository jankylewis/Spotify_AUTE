package se.pageObject;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.business.BasePage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RegistrationObject extends BasePage {
    protected RegistrationObject(Page page) {
        super(page);
    }

    protected final String BTN_NEXT = "//button[contains(@data-encore-id, 'buttonPrimary')]";

    //region At pre step

    protected class RegistrationObjectAtPreStep extends RegistrationObject {

        protected RegistrationObjectAtPreStep(Page page) {
            super(page);
        }

        protected final String TXT_EMAIL = "//input[contains(@id, 'username')]";
        protected final String LBL_USERNAME_ERRMSG = "//div[contains(@id, 'username-error-message')]";
    }

    //endregion

    //region At first step

    protected class RegistrationObjectAtFirstStep extends RegistrationObject {

        protected RegistrationObjectAtFirstStep(Page page) {
            super(page);
        }
        protected final String TXT_PASSWORD = "//input[contains(@id, 'new-password')]";
        protected final String LBL_PASSWORD_ERRMSG = "//div[contains(@id, 'password-error-message')]";
    }

    //endregion

    //region At second step

    protected class RegistrationObjectAtSecondStep extends RegistrationObject {

        protected RegistrationObjectAtSecondStep(Page page) {
            super(page);
        }

        protected final String TXT_DISPLAYED_NAME = "//input[contains(@id, 'displayName')]";
        protected final String TXT_BIRTHDATE = "//input[contains(@id, 'day')]";
        protected final String DDL_BIRTHMONTH = "//select[contains(@id, 'month')]";
        protected final String TXT_BIRTHYEAR = "//input[contains(@id, 'year')]";
        protected final @NotNull String RBTN_GENDER(String gender) {

            List<String> listOfUiGenders = Arrays.asList(
                    "man", "woman", "non-binary", "something else", "prefer not to say");

            List<String> listOfElementGenders = Arrays.asList(
                    "male", "female", "non_binary", "other", "prefer_not_to_say");

            int index;
            for (String _gender : listOfUiGenders) {
                if (Objects.equals(gender, _gender)) {

                    index = listOfUiGenders.indexOf(_gender);
                    String elementalGender = listOfElementGenders.get(index);

                    return new StringBuilder()
                            .append("//input[@value = '")
                            .append(elementalGender)
                            .append("' and contains(@id, '")
                            .append(elementalGender)
                            .append("')]")
                            .toString();
                }
            }

            throw new IllegalArgumentException("The desired gender was invalid!");
        }

        protected final String LBL_DISPLAYED_NAME_ERRMSG = "//div[contains(@id, 'displayname-error-message')]";
        protected final String LBL_GENDER_ERRMSG = "//div[contains(@id, 'gender-error-message')]";
        protected final String LBL_BIRTHDATE_YEAR_ERRMSG = "//div[contains(@id, 'birthdate-error-year_invalid')]";
        protected final String LBL_BIRTHDATE_YEAR_TOO_YOUNG_ERRMSG = "//div[contains(@id, 'birthdate-error-too_young')]";
        protected final String LBL_BIRTHDATE_DAY_ERRMSG = "//div[contains(@id, 'birthdate-error-day_invalid')]";
        protected final String LBL_BIRTHDATE_MONTH_ERRMSG = "//div[contains(@id, 'birthdate-error-month_invalid')]";
        protected final String LBL_BIRTHDATE_ERRMSG = "//div[contains(@id, 'birthdate-error-invalid')]";
    }

    //endregion

    //region At the latters

    protected class RegistrationObjectAtLatters extends RegistrationObject {

        protected RegistrationObjectAtLatters(Page page) {
            super(page);
        }

        protected final String CHK_MARKETING = "//label[contains(@for, 'checkbox-marketing')]//span";
        protected final String CHK_PRIVACY = "//label[contains(@for, 'checkbox-privacy')]//span";
        protected final String LBL_HUMAN_RECOGNITION = "//button[contains(@data-encore-id, 'buttonPrimary')]//preceding-sibling::h1";
        protected final String BTN_SIGN_UP = "//button[contains(@data-encore-id, 'buttonPrimary')]";
    }

    //endregion
}
