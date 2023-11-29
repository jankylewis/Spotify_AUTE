package se.business;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.commonHandler.baseService.BaseWaitHelper;
import se.model.SearchSongModel.ETab;
import se.pageObject.SearchSongObject;
import se.utility.GlobalVariableUtil;
import se.utility.ParallelUtil;

import java.util.*;

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

        BaseWaitHelper.forcedWait(3000);

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

    private void verifySongNameAtAllTab(final String verifiedSearchKey) throws Exception {

        boolean isSuccessfullyVerified;

        //Top result card (1 song)
        Locator topSongLbl = findLocator(LBL_TOP_RESULT(verifiedSearchKey));

        //Songs section (4 songs)
        List<Locator> listOfSongLbls = findListOfLocators(LBL_SONGS);

        //Artists section (4 artists)
        List<Locator> listOfArtists = findListOfLocators(LBL_ARTISTS);

        //Albums section (4 albums)
        List<Locator> listOfAlbums = findListOfLocators(LBL_ALBUMS);

        //Playlists section (4 playlists)
        List<Locator> listOfPlaylists = findListOfLocators(LBL_PLAYLISTS);

        //Podcasts section (4 podcasts) > Podcasts' Episodes section (4 eps)
        List<Locator> listOfPodcasts = findListOfLocators(LBL_PODCASTS);
        List<Locator> listOfEpisodes = findListOfLocators(LBL_EPISODES);

        //Profiles section (4 profiles)
        List<Locator> listOfProfiles = findListOfLocators(LBL_PROFILES);

        //Genres & Moods section (4 cards)
        List<Locator> listOfGenresAndMoods = findListOfLocators(LBL_GENRES_AND_MOODS);

        //Getting data for verification
        String topSongTxt = topSongLbl.textContent();
        Collection<String> songTxts = baseUi.getTextsFromLocators(listOfSongLbls);
        Collection<String> artistTxts = baseUi.getTextsFromLocators(listOfArtists);
        Collection<String> albumTxts = baseUi.getTextsFromLocators(listOfAlbums);
        Collection<String> playlistTxts = baseUi.getTextsFromLocators(listOfPlaylists);
        Collection<String> podcastTxts = baseUi.getTextsFromLocators(listOfPodcasts);
        Collection<String> episodeTxts = baseUi.getTextsFromLocators(listOfEpisodes);
        Collection<String> profileTxts = baseUi.getTextsFromLocators(listOfProfiles);
        Collection<String> genresNMoodTxts = baseUi.getTextsFromLocators(listOfGenresAndMoods);

        Collection<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> baseVerifier.verifyExpectedStringContained(verifiedSearchKey, topSongTxt));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, songTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, artistTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, albumTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, playlistTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, podcastTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, episodeTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, profileTxts));
        tasks.add(() -> verifyTextsContained(verifiedSearchKey, genresNMoodTxts));

        //Verification
        ParallelUtil.parallelTasks(tasks);

        isSuccessfullyVerified = true;
        if (isSuccessfullyVerified) {
            verificationWentPassed();
        }
    }

    private @NotNull Boolean verifyTextsContained(String verifiedKey, @NotNull Collection<String> actTexts) {

        for (String actText : actTexts) {
            baseVerifier.verifyExpectedStringContained(verifiedKey, actText);
        }

        return true;
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
                                             final String verifiedSearchKey) throws Exception {

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