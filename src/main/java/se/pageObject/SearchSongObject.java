package se.pageObject;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.business.BasePage;

public class SearchSongObject extends BasePage {

    protected SearchSongObject(Page page) {
        super(page);
    }

    protected final String E_INFINITE_SCROLL_LIST = "//div[contains(@data-testid, 'infinite-scroll-list')]";
    protected final String TXT_SEARCH_SONG = "//input[contains(@data-testid, 'search-input')]";
    protected final @NotNull String LNK_TAB(int tabIndex) {
        return new StringBuilder()
                .append("(//div[contains(@role, 'list')]//a)")
                .append("[")
                .append(tabIndex)
                .append("]")
                .toString();
    }

    //region At All Tab

    protected class SearchSongObjectAtAllTab extends SearchSongObject {

        protected SearchSongObjectAtAllTab(Page page) {
            super(page);
        }

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
        protected final String LBL_ARTISTS = "//section[contains(@aria-label, 'Artists')]//a";
        protected final String LBL_ALBUMS = "//section[contains(@aria-label, 'Albums')]//a[@title]";
        protected final String LBL_PLAYLISTS = "//section[contains(@aria-label, 'Playlists')]//a[@title]";
        protected final String LBL_PODCASTS = "//section[contains(@aria-label, 'Podcasts')]//a";
        protected final String LBL_EPISODES = "//section[contains(@aria-label, 'Episodes')]//a";
        protected final String LBL_PROFILES = "//section[contains(@aria-label, 'Profiles')]//a";
        protected final String LBL_GENRES_AND_MOODS = "//section[contains(@aria-label, 'Genres')]//a";
    }

    //endregion

    //region At Artists Tab

    protected class SearchSongObjectAtArtistsTab extends SearchSongObject {

        protected SearchSongObjectAtArtistsTab(Page page) {
            super(page);
        }

        protected final String LBL_ARTISTS = "//div[contains(@data-testid, 'search-category-card')]//a";
    }

    //endregion

    //region At Songs Tab

    protected class SearchSongObjectAtSongsTab extends SearchSongObject {

        protected SearchSongObjectAtSongsTab(Page page) {
            super(page);
        }

        protected final String LBL_SONGS = "//div[contains(@data-testid, 'tracklist')]//a[contains(@href, 'track')]";
    }

    //endregion

    //region At Playlists Tab

    protected class SearchSongObjectAtPlaylistsTab extends SearchSongObject {

        protected SearchSongObjectAtPlaylistsTab(Page page) {
            super(page);
        }

        protected final String LBL_PLAYLISTS = "//a[contains(@href, 'playlist/')]";
    }

    //endregion

    //region At Albums Tab

    protected class SearchSongObjectAtAlbumsTab extends SearchSongObject {

        protected SearchSongObjectAtAlbumsTab(Page page) {
            super(page);
        }

        protected final String LBL_ALBUMS = "//a[contains(@href, 'album/')]";
    }

    //endregion

    //region At Podcasts and Shows Tab

    protected class SearchSongObjectAtPodcastsAndShowsTab extends SearchSongObject {

        protected SearchSongObjectAtPodcastsAndShowsTab(Page page) {
            super(page);
        }

        protected final String LBL_PODCASTS_AND_SHOWS = "//section[contains(@data-testid, 'podcasts')]//a[contains(@href, 'show')]";
        protected final String LBL_EPISODES = "//a[contains(@href, 'episode/')]";
    }

    //endregion

    //region At Genres and Moods Tab

    protected class SearchSongObjectAtGenresAndMoodsTab extends SearchSongObject {

        protected SearchSongObjectAtGenresAndMoodsTab(Page page) {
            super(page);
        }

        protected final String LBL_GENRES = "//a[contains(@href, 'genre') and @title]";
    }

    //endregion

    //region At Profiles Tab

    protected class SearchSongObjectAtProfilesTab extends SearchSongObject {

        protected SearchSongObjectAtProfilesTab(Page page) {
            super(page);
        }

        protected final String LBL_PROFILES = "//a[contains(@href, 'user') and @title]";
    }

    //endregion
}


