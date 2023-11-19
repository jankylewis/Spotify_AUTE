package se.utility.fileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class BaseFileReader {

    public static class ResourceReader {                                //Enclosing class needs to be declared in static state

        public ResourceBundle resourceBundle;

        //region Getting property's value from Global Variable resources

        public String getPropertyFromGV(final String key, final String filePath) {

            try {
                
                String expValue = null;

                if (resourceBundle == null) {
                    getResourceBundle(filePath);                        //Getting resources file
                }

                expValue = resourceBundle.getString(key);               //Getting value accordingly to the desired key

                return expValue;

            } catch (IOException ioEx) {
                throw new RuntimeException("Error found: " + ioEx.getMessage() + " with causes from " + ioEx.getCause());
            } catch (MissingResourceException mrEx) {
                throw new RuntimeException("Error found: " + mrEx.getMessage() + " with causes from " + mrEx.getCause());
            }
        }

        //endregion

        //region Generating Resource Bundle service

        private ResourceBundle getResourceBundle(final String filePath) throws IOException, MissingResourceException {

            FileInputStream fis = new FileInputStream(filePath);        //Placing the file into resource firstly

            resourceBundle = new PropertyResourceBundle(fis);           //Generating Resource Bundle by fis

            return resourceBundle;
        }

        //endregion
    }
}
