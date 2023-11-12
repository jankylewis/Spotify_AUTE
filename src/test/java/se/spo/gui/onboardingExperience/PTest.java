package se.spo.gui.onboardingExperience;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.LogInPage;
import se.spo.gui.BaseTestService;

public class PTest extends BaseTestService {

    @Test
    protected void test01() {

        System.out.println("01");
    }

    @Test
    protected void test02() {

        System.out.println("02");
    }

    @BeforeMethod
    protected void testPre() {
//        new LogInPage(page.get()).navigateToLogInPage();
        new LogInPage(page).navigateToLogInPage();
    }

}
