package se.pageObject;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.business.BasePage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SignUpObject extends BasePage {
    public SignUpObject(Page page) {
        super(page);
    }

    public final String BTN_NEXT = "//button[contains(@data-encore-id, 'buttonPrimary')]";

    //region At first step

    public class SignUpObjectAtFirstStep extends SignUpObject {

        public SignUpObjectAtFirstStep(Page page) {
            super(page);
        }

        public final String TXT_EMAIL = "//input[contains(@id, 'username')]";
        public final String LBL_USERNAME_ERRMSG = "//div[contains(@id, 'username-error-message')]";
    }

    //endregion

    //region At second step

    public class SignUpObjectAtSecondStep extends SignUpObject {

        public SignUpObjectAtSecondStep(Page page) {
            super(page);
        }
        public final String TXT_PASSWORD = "//input[contains(@id, 'new-password')]";
        public final String LBL_PASSWORD_ERRMSG = "//div[contains(@id, 'password-error-message')]";
    }

    //endregion

    //region At third step

    public class SignUpObjectAtThirdStep extends SignUpObject {

        public SignUpObjectAtThirdStep(Page page) {
            super(page);
        }

        public final String TXT_DISPLAYED_NAME = "//input[contains(@id, 'displayName')]";
        public final String TXT_BIRTHDATE = "//input[contains(@id, 'day')]";
        public final String DDL_BIRTHMONTH = "//select[contains(@id, 'month')]";
        public final String TXT_BIRTHYEAR = "//input[contains(@id, 'year')]";
        public final @NotNull String RBTN_GENDER(String gender) {

            List<String> listOfUiGenders = Arrays.asList(
                    "man", "woman", "non-binary", "something else", "prefer not to say");

            List<String> listOfElementGenders = Arrays.asList(
                    "male", "female", "non_binary", "other", "prefer_not_to_say");

            int index = -1;     //Forcing a default value
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

        public final String LBL_DISPLAYED_NAME_ERRMSG = "//div[contains(@id, 'displayname-error-message')]";
        public final String LBL_GENDER_ERRMSG = "//div[contains(@id, 'gender-error-message')]";

        public final String LBL_BIRTHDATE_YEAR_ERRMSG = "//div[contains(@id, 'birthdate-error-year_invalid')]";
        public final String LBL_BIRTHDATE_DAY_ERRMSG = "//div[contains(@id, 'birthdate-error-day_invalid')]";
        public final String LBL_BIRTHDATE_MONTH_ERRMSG = "//div[contains(@id, 'birthdate-error-month_invalid')]";
        public final String LBL_BIRTHDATE_ERRMSG = "//div[contains(@id, 'birthdate-error-invalid')]";
    }

    //endregion
}
