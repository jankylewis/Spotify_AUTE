package se.ebay.gui;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import se.business.HomePage;
import se.infrastructure.PlaywrightFactory;

public class BaseTest {

//region Introducing fields

    protected PlaywrightFactory pf;
    protected Page page;
    protected HomePage homePage;

    //endregion


    @BeforeSuite
    public void testPreparation() {
        pf = new PlaywrightFactory();
        page = pf.initializeBrowser("chrome", true);
    }

    @AfterSuite
    public void testCleaning() {

    }


}
