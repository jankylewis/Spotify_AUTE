package se.spo.gui;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import se.business.BasePage;
import se.commonHandler.baseService.BaseService;
import se.infrastructure.PlaywrightFactory;

public class BaseTestService extends BaseService {             //This service runs before each test class

    //region Introducing variables

    protected Page page;
    private BasePage basePage;
    private PlaywrightFactory playwrightFactory;

    //endregion

    protected Page produceInteractivePage() {

        if (playwrightFactory == null) {
            playwrightFactory = new PlaywrightFactory();
        }

        //Producing a new Interactive Page
        return playwrightFactory.initializeInteractiveBrowser(gvbc.browserType, !gvbc.isHeadless);
    }

    @BeforeTest
    protected void testInitialization() {
        page = produceInteractivePage();
        basePage = new BasePage(page);
    }


    @AfterTest
    protected void testTermination() {
        System.out.println("Current Thread Id: " + Thread.currentThread().threadId());
        System.out.println("Current Thread Name: " + Thread.currentThread().getName());
        System.out.println("Current Thread Group: " + Thread.currentThread().getThreadGroup());
    }

}
