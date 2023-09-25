package se.pageObject;

import com.microsoft.playwright.Page;

public class BaseObject {

    protected Page page;

    public BaseObject(Page page) {
        this.page = page;
    }
}
