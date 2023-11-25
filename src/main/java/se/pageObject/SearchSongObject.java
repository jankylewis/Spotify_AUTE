package se.pageObject;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.business.BasePage;

public class SearchSongObject extends BasePage {

    private StringBuilder stringBuilder;

    protected SearchSongObject(Page page) {
        super(page);
    }

    {
        stringBuilder = new StringBuilder();
    }

    protected final String TXT_SEARCH_SONG = "//input[contains(@data-testid, 'search-input')]";
    protected final @NotNull String LNK_TAB(int tabIndex) {
        return stringBuilder.append("(//div[contains(@role, 'list')]//a)")
                .append("[")
                .append(tabIndex)
                .append("]")
                .toString();
    }

    //At All Tab
//    protected final String SECTION_TOP_RESULT = "//section[contains(@aria-label, 'Top result')]";
    //a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'what')]
    protected final @NotNull String LBL_TOP_RESULT(String searchKey) {
        return stringBuilder.append("//section[contains(@aria-label, 'Top result')]")
                .append("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '")
                .append(searchKey)
                .append("')]")
                .toString();
    }

}
