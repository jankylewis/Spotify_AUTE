package se.pageObject;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.business.BasePage;

public class SearchSongObject extends BasePage {

    protected SearchSongObject(Page page) {
        super(page);
    }

    protected final String TXT_SEARCH_SONG = "//input[contains(@data-testid, 'search-input')]";
    protected final @NotNull String LNK_TAB(int tabIndex) {
        return new StringBuilder()
                .append("(//div[contains(@role, 'list')]//a)")
                .append("[")
                .append(tabIndex)
                .append("]")
                .toString();
    }

    //At All Tab
    protected final @NotNull String LBL_TOP_RESULT(String searchKey) {
        return new StringBuilder()
                .append("//section[contains(@aria-label, 'Top result')]")
                .append("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '")
                .append(searchKey)
                .append("')]")
                .toString();
    }
    protected final String LBL_SONGS = "//section[contains(@aria-label, 'Songs')]//a[contains(@href, 'track')]";
    protected final String LBL_FEATURED_SONGS = "//section[contains(@aria-label, 'Featuring')]//a";

}
