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

    protected class SearchSongObjectAtAllTab extends SearchSongObject {

        protected SearchSongObjectAtAllTab(Page page) {
            super(page);
        }

        protected final String LBL_SONGS = "//section[contains(@aria-label, 'Songs')]//a[contains(@href, 'track')]";
        protected final String LBL_FEATURED_SONGS = "//section[contains(@aria-label, 'Featuring')]//a";
        protected final String LBL_ARTISTS = "//section[contains(@aria-label, 'Artists')]//a";
        protected final String LBL_ALBUMS = "//section[contains(@aria-label, 'Albums')]//a[@title]";
        protected final String LBL_PLAYLISTS = "//section[contains(@aria-label, 'Playlists')]//a[@title]";
        protected final String LBL_PODCASTS = "//section[contains(@aria-label, 'Podcasts')]//a";
        protected final String LBL_EPISODES = "//section[contains(@aria-label, 'Episodes')]//a";
        protected final String LBL_PROFILES = "//section[contains(@aria-label, 'Profiles')]//a";
        protected final String LBL_GENRES_AND_MOODS = "//section[contains(@aria-label, 'Genres')]//a";
    }

    protected class SearchSongObjectAtArtistsTab extends SearchSongObject {

        protected SearchSongObjectAtArtistsTab(Page page) {
            super(page);
        }

        protected final String LBL_ARTISTS = "//div[contains(@data-testid, 'search-category-card')]//a";
    }
}


