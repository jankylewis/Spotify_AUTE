package se.commonHandler.ConstantContainer;

import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;

public class WaitConstant {

    public static final WaitUntilState DOMCONTENTWAITER = WaitUntilState.DOMCONTENTLOADED;
    public static final WaitUntilState COMMITWAITER = WaitUntilState.COMMIT;
    public static final WaitUntilState NETWORKIDLEWAITER = WaitUntilState.NETWORKIDLE;
    public static final WaitUntilState LOADWAITER = WaitUntilState.LOAD;

    public static final WaitForSelectorState SELECTORATTACHED = WaitForSelectorState.ATTACHED;
    public static final WaitForSelectorState SELECTORDETACHED = WaitForSelectorState.DETACHED;
    public static final WaitForSelectorState SELECTORHIDDEN = WaitForSelectorState.HIDDEN;
    public static final WaitForSelectorState SELECTORVISIBLE = WaitForSelectorState.VISIBLE;

    //region Timeout by milliseconds

    public static final int MAXTIMEOUT = 30000;
    public static final int MINTIMEOUT = 200;
    public static final int TIMEOUT1S = 1000;
    public static final int TIMEOUT3S = 3000;
    public static final int TIMEOUT5S = 5000;

    //endregion

}
