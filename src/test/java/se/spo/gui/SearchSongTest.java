package se.spo.gui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.SearchSongPage;
import se.model.SearchSongModel.ETab;

public class SearchSongTest extends BaseTestService {

    //region Introducing objects

    private SearchSongPage searchPage;
    private String searchKey;

    //endregion

    //region Verifying User's experience of searching songs

    @Test(
            priority = 1,
            testName = "SWSEARCH_01: All Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtAllTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.ALL)
                .verifySongNameMatchedKeyword(ETab.ALL, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_02: Artists Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtArtistsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.ARTISTS)
                .verifySongNameMatchedKeyword(ETab.ARTISTS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_03: Songs Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtSongsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.SONGS)
                .verifySongNameMatchedKeyword(ETab.SONGS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_04: Playlists Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtPlaylistsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.PLAYLISTS)
                .verifySongNameMatchedKeyword(ETab.PLAYLISTS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_05: Albums Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtAlbumsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.ALBUMS)
                .verifySongNameMatchedKeyword(ETab.ALBUMS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_06: Podcasts and Shows Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtPodcastsAndShowsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.PODCASTS_AND_SHOWS)
                .verifySongNameMatchedKeyword(ETab.PODCASTS_AND_SHOWS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_07: Genres and Moods Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtGenresAndMoodsTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.GENRES_AND_MOODS)
                .verifySongNameMatchedKeyword(ETab.GENRES_AND_MOODS, searchKey);
    }

    @Test(
            priority = 2,
            testName = "SWSEARCH_08: Genres and Moods Tab > Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfullyAtProfilesTab() throws InterruptedException {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.PROFILES)
                .verifySongNameMatchedKeyword(ETab.PROFILES, searchKey);
    }

    //endregion

    //region Test preparation

    @BeforeMethod
    protected void testPreparation() {

        searchPage = new SearchSongPage(page);

    }

    //endregion
}
