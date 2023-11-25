package se.business;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.model.SearchSongModel.ETab;
import se.pageObject.SearchSongObject;
import se.utility.GlobalVariableUtil;

import java.util.Objects;

public class SearchSongPage extends SearchSongObject
        implements IVerification {
    public SearchSongPage(Page page) {
        super(page);
    }

    public SearchSongPage navigateToSearchSongPage() {

        baseUi.navigateToUrl(GlobalVariableUtil.Environment.publicUrl +
                localPathConst.SEARCH_SONG_PATH);

        return this;
    }

    public SearchSongPage searchSong(String songName) {

        baseUi.sendKeyToElement(findLocator(TXT_SEARCH_SONG), songName);
        baseUi.pressKey("Enter");

        return this;
    }

    public SearchSongPage switchToTab(@NotNull ETab tab) {
        baseUi.clickOnElement(
                findLocator(LNK_TAB(getTabIndex(tab.getEValue()))));
        return this;
    }

    private int getTabIndex(@NotNull String tab) {

        for (ETab _tab : ETab.values()) {
            if (Objects.equals(_tab.getEValue(), tab)) {
                return _tab.ordinal()+1;
            }
        }

        throw new IllegalArgumentException("The inputted tab was not valid!");
    }

    //region Verifications section

    private void verifySongNameAtAllTab(final String verifiedSearchKey) {

        //Top result card (1 song)
        Locator topSongLbl = findLocator(LBL_TOP_RESULT(verifiedSearchKey));

        //Songs section (4 songs)


        //Featuring of the top-result song section (2 songs)


        //Artists section (4 artists)


        //Albums section (4 albums)


        //Playlists section (4 playlists)


        //Podcasts section (4 podcasts) > Podcasts' Episodes section (4 eps)


        //Profiles section (4 profiles)


        //Genres & Moods section (4 cards)


        //Verification
        if (baseVerifier.verifyExpectedStringContained(verifiedSearchKey, topSongLbl.textContent())) {
            verificationWentPassed();
        }

    }

    private void verifySongNameAtArtistsTab(final String verifiedSearchKey) {

    }
    private void verifySongNameAtSongsTab(final String verifiedSearchKey) {

    }

    private void verifySongNameAtPlaylistsTab(final String verifiedSearchKey) {

    }

    private void verifySongNameAtAlbumsTab(final String verifiedSearchKey) {

    }

    private void verifySongNameAtPodcastsNShowsTab(final String verifiedSearchKey) {

    }

    private void verifySongNameAtGenresNMoodsTab(final String verifiedSearchKey) {

    }

    private void verifySongNameAtProfilesTab(final String verifiedSearchKey) {

    }

    public void verifySongNameMatchedKeyword(@NotNull ETab verifiedTab,
                                             final String verifiedSearchKey) {

        switch (verifiedTab) {
            case ALL -> verifySongNameAtAllTab(verifiedSearchKey);
            case SONGS -> verifySongNameAtSongsTab(verifiedSearchKey);
            case ARTISTS -> verifySongNameAtArtistsTab(verifiedSearchKey);
            case ALBUMS -> verifySongNameAtAlbumsTab(verifiedSearchKey);
            case PODCASTS_AND_SHOWS -> verifySongNameAtPodcastsNShowsTab(verifiedSearchKey);
            case GENRES_AND_MOODS -> verifySongNameAtGenresNMoodsTab(verifiedSearchKey);
            case PROFILES -> verifySongNameAtProfilesTab(verifiedSearchKey);
            case PLAYLISTS -> verifySongNameAtPlaylistsTab(verifiedSearchKey);
        }

        verificationWentPassed();
    }

    //region IVerification

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion

    //endregion
}
