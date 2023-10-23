package se.spo.gui.onboardingExperience;

import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import se.business.SignUpPage;
import se.commonHandler.baseService.BaseService;
import se.spo.gui.BaseTestService;

public class SignUpTest extends BaseTestService {

    @Test(priority = 1)
    public void signUpUnsuccessfullyWithInvalidPrefix() {
        System.out.println("Prefix -> Current thread id: "+ Thread.currentThread().getId());
        System.out.println("Prefix -> Current thread name: "+ Thread.currentThread().getName());
    }

    @Test(priority = 1)
    public void signUpUnsuccessfullyWithInvalidSuffix() {
        System.out.println("Suffix -> Current thread id: "+ Thread.currentThread().getId());
        System.out.println("Suffix -> Current thread name: "+ Thread.currentThread().getName());
    }


//    @BeforeTest
//    public void be4Test() {
//        Page page = getPage();
//
//        new SignUpPage(page).navigateToSignUpPage();
//    }

    @BeforeMethod
    public void be4TestMethod() {
        setTlPage();

        Page page = getTlPage();

        new SignUpPage(page).navigateToSignUpPage();
    }

}
