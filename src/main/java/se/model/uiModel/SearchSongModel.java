package se.model.uiModel;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class SearchSongModel {

    //region Search Tab enumeration

    public enum ETab {
        ALL("All"),
        ARTISTS("Artists"),
        SONGS("Songs"),
        PLAYLISTS("Playlists"),
        ALBUMS("Albums"),
        PODCASTS_AND_SHOWS("Podcasts & Shows"),
        GENRES_AND_MOODS("Genres & Moods"),
        PROFILES("Profiles");

        private final String _value;

        ETab(String value) {
            this._value = value;
        }

        public String getEValue() {
            return _value;
        }

        @Override
        public @NotNull String toString() {
            return getEValue();
        }

        @Contract("null -> fail")
        public static @NotNull ETab getETab(String value) {

            if (value == null) {
                throw new IllegalArgumentException("The inputted tab was empty!");
            }

            for (ETab tab : values()) {
                if (value.equalsIgnoreCase(tab.getEValue())) {
                    return tab;
                }
            }

            throw new IllegalArgumentException("The inputted tab did not match any values!");
        }
    }

    //endregion
}
