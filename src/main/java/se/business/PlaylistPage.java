package se.business;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import se.commonHandler.baseService.BaseVerification.IVerification;
import se.pageObject.PlaylistObject;

import java.util.List;

public class PlaylistPage extends PlaylistObject implements IVerification {

    public PlaylistPage(Page page) {
        super(page);
    }

    //region Taking UI actions

    public PlaylistPage deleteAllExistingPlaylists() {

        List<Locator> listOfPlaylistLocators = findListOfLocators(DIV_PLAYLISTS);

        int idx = 0;

        //Cleaning all existing playlists
        while (idx < listOfPlaylistLocators.size()) {

            baseUi.clickOnElementByForcing(listOfPlaylistLocators.get(0));
            baseUi.clickOnElement(findLocator(BTN_MORE));
            baseUi.clickOnElement(findLocator(BTN_DELETE));
            baseUi.clickOnElement(findLocator(BTN_DELETE_ON_CONFIRMATION_MODAL));

            idx++;
        }

        return this;
    }

    //endregion

    //region Verifications

    public PlaylistPage verifyAllExistingPlaylistsDeleted() {

        if (baseVerification.verifyElementVisible(findLocator(LBL_CREATE_YOUR_FIRST_PLAYLIST))) {
            verificationWentPassed();
        }
        else {
            verificationWentFailed();
        }

        return this;
    }

    //endregion

    //region Verification services

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion
}
