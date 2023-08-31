package se.business;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private Page page;

    //Introducing constructor
    public HomePage(Page page) {
        this.page = page;
    }

}
