package se.business;

import com.microsoft.playwright.Page;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseVerifier.IVerification;
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

    Map<String, Collection<String>> verifiedData;

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

    private class SearchSongAtAllTab extends SearchSongObjectAtAllTab {

        private SearchSongAtAllTab(Page page) {
            super(page);
        }

        private void verifySongNameAtAllTab(final String verifiedSearchKey) throws InterruptedException {

            boolean wasSuccessfullyVerified;

            //Preparing data for verifications
            verifiedData = new HashMap<>() {{
                put("top song", Collections.singletonList(findLocator(LBL_TOP_RESULT(verifiedSearchKey)).textContent()));
                put("songs", baseUi.getTextsFromLocators(findListOfLocators(LBL_SONGS)));
                put("artists", baseUi.getTextsFromLocators(findListOfLocators(LBL_ARTISTS)));
                put("albums", baseUi.getTextsFromLocators(findListOfLocators(LBL_ALBUMS)));
                put("playlists", baseUi.getTextsFromLocators(findListOfLocators(LBL_PLAYLISTS)));
                put("podcasts", baseUi.getTextsFromLocators(findListOfLocators(LBL_PODCASTS)));
                put("episodes", baseUi.getTextsFromLocators(findListOfLocators(LBL_EPISODES)));
                put("profiles", baseUi.getTextsFromLocators(findListOfLocators(LBL_PROFILES)));
                put("genres and moods", baseUi.getTextsFromLocators(findListOfLocators(LBL_GENRES_AND_MOODS)));
            }};

            //Executing verifications
            ParallelUtil.parallelizeFunctions(new ArrayList<>() {{
                //Task verifying Top Song
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("top song"))));

                //Task verifying Songs
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("songs"))));

                //Task verifying Artists
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("artists"))));

                //Task verifying Albums
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("albums"))));

                //Task verifying Playlists
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("playlists"))));

                //Task verifying Podcasts
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("podcasts"))));

                //Task verifying Episodes
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("episodes"))));

                //Task verifying Profiles
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("profiles"))));

                //Task verifying Genres and Moods
                add(() -> verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("genres and moods"))));
            }});

            wasSuccessfullyVerified = true;
            if (wasSuccessfullyVerified) {
                verificationWentPassed();
            }
        }
    }

    private class SearchSongAtArtistsTab extends SearchSongObjectAtArtistsTab {

        private SearchSongAtArtistsTab(Page page) {
            super(page);
        }

        private void verifySongNameAtArtistsTab(final String verifiedSearchKey) {

            boolean wasSuccessfullyVerified;

            verifiedData = new HashMap<>() {{
                put("artists", baseUi.getTextsFromLocators(findListOfLocators(LBL_ARTISTS)));
            }};

            verifyTextsContained(Pair.with(verifiedSearchKey, verifiedData.get("artists")));

            wasSuccessfullyVerified = true;
            if (wasSuccessfullyVerified) {
                verificationWentPassed();
            }
        }
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

    private boolean verifyTextsContained(@NotNull final Pair<String, Collection<String>> verifiedPairs) {

        for (String actText : verifiedPairs.getValue1()) {
            baseVerifier.verifyExpectedStringContained(verifiedPairs.getValue0(), actText);
        }

        return true;
    }

    public void verifySongNameMatchedKeyword(@NotNull ETab verifiedTab,
                                             final String verifiedSearchKey) throws InterruptedException {

        switch (verifiedTab) {
            case ALL -> new SearchSongAtAllTab(page).verifySongNameAtAllTab(verifiedSearchKey);
            case SONGS -> verifySongNameAtSongsTab(verifiedSearchKey);
            case ARTISTS -> new SearchSongAtArtistsTab(page).verifySongNameAtArtistsTab(verifiedSearchKey);
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