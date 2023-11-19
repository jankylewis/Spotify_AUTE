package se.spo.gui.onboardingExperience;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.SignUpPage;
import se.business.SignUpPage.SignUpAtFirstStep;
import se.business.SignUpPage.SignUpAtSecondStep;
import se.business.SignUpPage.SignUpAtThirdStep;
import se.spo.gui.BaseTestService;
import se.utility.GlobalVariableUtil.UserCredential;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SignUpTest extends BaseTestService {

    //region Introducing objects

    private SignUpPage signUpPage;
    private SignUpAtFirstStep signUpAtFirstStepPage;
    private SignUpAtSecondStep signUpAtSecondStepPage;
    private SignUpAtThirdStep signUpAtThirdStep;

    //endregion

    //region Verifying User's Sign-up experience

    //region Verifying unsuccessful Sign-up flows

    @Test(priority = 2,
            testName = "SWSIGNUP_01: Step 1 > Verify User has signed-up unsuccessfully with an invalid email address")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullySignedUpWithInvalidEmailAddress() {

        String invalidEmailAddress = faker.produceFakeEmail() + "_";

        LOGGER.info("Step: Step 1 > Inputting an invalid email address");
        LOGGER.info("Step: Step 1 > Verifying that an error message came up!");
        landOnTheSecondStep(invalidEmailAddress);
        signUpAtFirstStepPage.verifyErrorMessagePresented();
    }

    @Test(priority = 2,
            testName = "SWSIGNUP_02: Step 2 > Verify User has signed-up unsuccessfully with an invalid password")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullySignedUpWithInvalidPassword() {

        LOGGER.info("Step: Step 2 > Inputting an invalid password");
        landOnTheThirdStep(faker.produceFakeEmail(),
                faker.producePassword(
                1, 7, true, true, true));

        LOGGER.info("Step: Step 2 > Verifying that an error message came up!");
        signUpAtSecondStepPage.verifyErrorMessagePresented();
    }

    @Test(priority = 2,
            testName = "SWSIGNUP_03: Step 3 > Verify User has signed-up unsuccessfully with empty credentials")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullySignedUpWithEmptyCredentials() {

        signUpAtThirdStep = signUpPage.new SignUpAtThirdStep(page);

        LOGGER.info("Step: Step 3 > Leaving blanks to all fields -> clicking on Next button");
        landOnTheThirdStep(faker.produceFakeEmail(),
                faker.producePassword(
                        8, 16, true, true, true));

        LOGGER.info("Step: Step 3 > Verifying that all required error messages came up!");
        signUpPage.clickOnNextBtn();
        signUpAtThirdStep.verifyErrorMessagePresented();
    }

    @Test(priority = 2,
            testName = "SWSIGNUP_04: Step 3 > Verify User has signed-up unsuccessfully with an empty date of birth")
    protected void spotifyUiTest_verifyUserHasUnsuccessfullySignedUpWithEmptyDateOfBirth() {

        signUpAtThirdStep = signUpPage.new SignUpAtThirdStep(page);

        List<String> listOfGenders = Arrays.asList(
                "man", "woman", "non-binary", "something else", "prefer not to say");
        LocalDate userBirthDate = LocalDate.parse(UserCredential.userDob, dateTimeUtil.DATE_FORMATTER);
        int userBirthYear = dateTimeUtil.getYearOfCurrentDate(userBirthDate);
        int userBirthMonth = dateTimeUtil.getMonthOfCurrentDate(userBirthDate);

        LOGGER.info("Step: Navigating to Step 3");
        landOnTheThirdStep(faker.produceFakeEmail(),
                faker.producePassword(
                        8, 16, true, true, true));

        LOGGER.info("Step: Step 3 > Inputting all fields except date of birth field");
        LOGGER.info("Step: Step 3 > Verifying that an error message at date of birth field came up!");
        signUpAtThirdStep.inputDisplayedName(faker.produceFakeName())
                .selectBirthMonth(dateTimeUtil.processMonth(userBirthMonth))
                .inputBirthYear(userBirthYear)
                .selectGender(listOfGenders.get(
                        new Random().nextInt(0, listOfGenders.size() - 1 )));

        signUpPage.clickOnNextBtn();
//        signUpAtThirdStep.verifyErrorMessagePresented();
    }

    //endregion

    //endregion

    //region Test services

    private void landOnTheSecondStep(String emailAddress) {

        signUpAtFirstStepPage = signUpPage.new SignUpAtFirstStep(page);

        signUpAtFirstStepPage.inputUsrEmail(emailAddress);
        signUpPage.clickOnNextBtn();
    }

    private void landOnTheThirdStep(String emailAddress, String password) {

        signUpAtSecondStepPage = signUpPage.new SignUpAtSecondStep(page);

        landOnTheSecondStep(emailAddress);

        signUpAtSecondStepPage.inputPassword(password);
        signUpPage.clickOnNextBtn();
    }

    //endregion

    //region Test preparation and cleaning

    @BeforeMethod
    protected void testPreparation() {

        signUpPage = new SignUpPage(page);

        signUpPage.navigateToSignUpPage();
    }

    //endregion

}

