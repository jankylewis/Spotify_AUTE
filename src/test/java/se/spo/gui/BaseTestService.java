package se.spo.gui;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import se.commonHandler.baseService.BaseService;
import se.infrastructure.PlaywrightFactory;
import se.infrastructure.PlaywrightManager;
import se.pageObject.BaseObject;

public class BaseTestService extends BaseService {             //This service runs before each test class

    //region Introducing variables

    protected Page page;
    private static BaseObject baseObject;

    //endregion

    protected Page produceInteractivePage() {

        //Producing a new Interactive Page
        return PlaywrightFactory.produceInteractiveBrowser();
    }

    @BeforeTest
    protected void testInitialization() {
        page = produceInteractivePage();
        baseObject = new BaseObject(page);
    }

    @AfterTest
    protected void testTermination() {

        PlaywrightManager.disposingThreads();

        LOGGER.info("Current Thread Id: " + Thread.currentThread().threadId());
        LOGGER.info("Current Thread Name: " + Thread.currentThread().getName());
    }

}
