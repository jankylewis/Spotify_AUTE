package se.spo.gui.searchingExperience.ForTesting;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ThreadLocalPracticing extends BaseTL {

    @Test
    public void test01() {
        page.navigate("https://www.spotify.com/vn-vi/signup");
        System.out.println("01 - Current thread id: " + Thread.currentThread().getId());

//        System.out.println("Current class: " + new Object(){}.getClass());

//        System.out.println("Current TM name: " + threadHandler.getCurrentThread(Thread.currentThread(), threadHandler.getCurrentTestMethodName(getClass())).getName());
    }

    @Test
    public void test02() {
        page.navigate("https://www.spotify.com/vn-vi/signup");
        System.out.println("02 - Current thread id: " + Thread.currentThread().getId());
    }

    @BeforeMethod
    public void be4M() {
        page = getMPage();
    }

}
