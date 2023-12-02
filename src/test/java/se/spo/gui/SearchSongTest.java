package se.spo.gui;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import se.business.SearchSongPage;
import se.model.SearchSongModel.ETab;

public class SearchSongTest extends BaseTestService {

    //region Introducing objects

    private SearchSongPage searchPage;
    private String searchKey;

    //endregion

    //region Verifying User's experience of searching songs with hard-coded data

    @Test(
            priority = 1,
            testName = "SWSEARCH_01: All Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtAllTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.ALL)
                .verifySongNameMatchedKeyword(ETab.ALL, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_02: Artists Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtArtistsTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.ARTISTS)
                .verifySongNameMatchedKeyword(ETab.ARTISTS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_03: Songs Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtSongsTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.SONGS)
                .verifySongNameMatchedKeyword(ETab.SONGS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_04: Playlists Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtPlaylistsTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.PLAYLISTS)
                .verifySongNameMatchedKeyword(ETab.PLAYLISTS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_06: Podcasts and Shows Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtPodcastsAndShowsTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.PODCASTS_AND_SHOWS)
                .verifySongNameMatchedKeyword(ETab.PODCASTS_AND_SHOWS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_07: Genres and Moods Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtGenresAndMoodsTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.GENRES_AND_MOODS)
                .verifySongNameMatchedKeyword(ETab.GENRES_AND_MOODS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_08: Genres and Moods Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtProfilesTab() throws InterruptedException {

        searchPage.searchSong(searchKey = "what")
                .switchToTab(ETab.PROFILES)
                .verifySongNameMatchedKeyword(ETab.PROFILES, searchKey);
    }

    //endregion

    //region Verifying User's experience of searching songs with dynamic data

    @Test(
            priority = 2,
            testName = "SWSEARCH_05: Albums Tab > Verify User has successfully searched his desired songs",
            dataProvider = "SuccessfulSearchData"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtAlbumsTab(String searchKey)
            throws InterruptedException {

        searchPage.searchSong(searchKey)
                .switchToTab(ETab.ALBUMS)
                .verifySongNameMatchedKeyword(ETab.ALBUMS, searchKey);
    }

    @Test(
            priority = 3,
            testName = "SWSEARCH_09: Podcasts and Shows Tab > Verify User has unsuccessfully searched his desired songs",
            dataProvider = "FailedSearchData"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsUnsuccessfullyAtPodcastsAndShowsTab(String searchKey) {

        searchPage.searchSong(searchKey)
                .verifyNoResultsMessageFound(searchKey);
    }

    //endregion

    //region Test data preparation

    @Contract(value = " -> new", pure = true)
    @DataProvider(
            name = "SuccessfulSearchData",
            parallel = false,       //To be true -> throwing <com.microsoft.playwright.PlaywrightException: Cannot find command to respond>
            propagateFailureAsTestFailure = false
    )
    private Object @NotNull [] getSuccessfulSearchData() {

        return new Object[] {
                "what",
                "since",
                "when",
                "pop",
                "smoke"
        };
    }

    @Contract(value = " -> new", pure = true)
    @DataProvider(
            name = "FailedSearchData",
            parallel = false,
            propagateFailureAsTestFailure = false
    )
    private Object @NotNull [] getFailedSearchData() {

        return new Object[] {
                "turbulent gratifications and glorified victory with successful procedure. One of the most important thing is that you have to be persistent enough, studying makes our knowledge stronger on a daily basis. Whenever our bodies tend to be given up, we must wake ourselves up to take more steps",
                "I always love reading books while eating breakfasts, lunches and dinners. However, an exceptionally story came up with my soul, though, it made me delightful. I then finished my meal and hit the sack regardless of how weird the story were. Could you please guess what did \"exceptionally\" mean?"
        };
    }

    //endregion

    //region Test preparation

    @BeforeMethod
    protected void testPreparation() {

        searchPage = new SearchSongPage(page)
                .navigateToSearchSongPage();

    }

    //endregion
}
