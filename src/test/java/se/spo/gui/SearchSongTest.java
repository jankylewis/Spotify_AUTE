package se.spo.gui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.business.SearchSongPage;
import se.commonHandler.baseService.BaseWaitHelper;
import se.model.SearchSongModel.ETab;

public class SearchSongTest extends BaseTestService {

    //region Introducing objects

    private SearchSongPage searchPage;
    private String searchKey;

    //endregion

    //region Verifying User's experience of searching songs

    @Test(
            priority = 1,
            testName = "SWSEARCH_01: Verify User has successfully searched his desired songs"
    )
    protected void spotifyUiTest_verifyUserSearchedSongsSuccessfully() throws Exception {

        searchPage.navigateToSearchSongPage()
                .searchSong(searchKey = "what")
                .switchToTab(ETab.ALL)
                .verifySongNameMatchedKeyword(ETab.ALL, searchKey);

        BaseWaitHelper.forcedWait(4000);

    }

    //endregion

    //region Test preparation

    @BeforeMethod
    protected void testPreparation() {

        searchPage = new SearchSongPage(page);

    }

    //endregion
}
