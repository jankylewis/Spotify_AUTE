package se.utility.fileReader;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class BaseFileReader {

    public static class ResourceReader {                                //Enclosing class needs to be declared in static state

        public static ResourceBundle resourceBundle;

        //region Getting property's value from Global Variable resources

        public static @NotNull String getPropertyFromGV(final String key, final String filePath) {

            try {
                
                String expValue = null;

                if (resourceBundle == null) {
                    getResourceBundle(filePath);                        //Getting resources file
                }

                expValue = resourceBundle.getString(key);               //Getting value accordingly to the desired key

                return expValue;

            } catch (IOException | MissingResourceException ioEx) {
                throw new RuntimeException("Error found: " + ioEx.getMessage() + " with causes from " + ioEx.getCause());
            }
        }

        //endregion

        //region Generating Resource Bundle service

        private static ResourceBundle getResourceBundle(final String filePath) throws IOException, MissingResourceException {

            FileInputStream fis = new FileInputStream(filePath);        //Placing the file into resource firstly

            resourceBundle = new PropertyResourceBundle(fis);           //Generating Resource Bundle by fis

            return resourceBundle;
        }

        //endregion
    }
}
