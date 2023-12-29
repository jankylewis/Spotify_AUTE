package se.commonHandler.constantHouse.uiConstant;

import se.utility.StringUtil;

import java.util.Arrays;

public final class MessageConstant {

    //region Log-in flows

    public final String LBL_INVALID_CREDENTIALS = "Incorrect username or password.";

    //endregion

    //region Sign-up flows

    //Sign-up Page > pre Step

    public final String LBL_INVALID_USERNAME = "This email is invalid. Make sure it's written like example@email.com";

    //Sign-up Page > Step 1

    public final String LBL_INVALID_PASSWORD = "Password should contain at least 8 characters.";

    //Sign-up Page > Step 2

    public final String LBL_REQUIRED_DISPLAYED_NAME = "Enter a name for your profile.";
    public final String LBL_REQUIRED_DOB = "Please enter your date of birth.";
    public final String LBL_REQUIRED_GENDER = "Select your gender.";
    public final String LBL_INVALID_BIRTHDATE = "Please enter the day of your birth date by entering a number between 1 and 31.";
    public final String LBL_INVALID_BIRTHYEAR = "You’re too young to create a Spotify account.";

    //endregion

    //region Sign-up page > Latters

    public final String LBL_HUMAN_RECOGNITION = "We need to make sure that you're a human";

    //endregion

    //region Searches

    public final String LBL_USE_DIFFERENT_KEYWORDS = "Please make sure your words are spelled correctly, or use fewer or different keywords.";
    public String LBL_NO_RESULTS_FOUND(String searchKey) {

        return StringUtil.appendStrings(Arrays.asList(
                "No results found for",
                "\"",
                searchKey,
                "\""
        ));
    }


    //endregion
}
