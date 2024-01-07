package se.utility.fileUtil.fileReaderUtil;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyFileReader {

    public static class ResourceReader {            //Enclosing class needs to be declared in static state

        private ResourceReader(){}

        private static class ResourceReaderHelper {
            private static final ResourceReader INSTANCE = new ResourceReader();
        }

        public static ResourceReader getInstance() {
            return ResourceReaderHelper.INSTANCE;
        }

        public ResourceBundle resourceBundle;

        //region Getting property's value from Global Variable resources

        public String getPropertyFromGV(final String key, final String filePath) {

            try {

                String expValue;
                resourceBundle = getResourceBundle(filePath);           //Getting resources file
                expValue = resourceBundle.getString(key);               //Getting value accordingly to the desired key

                return expValue;

            } catch (IOException | MissingResourceException generalEx) {
                throw new RuntimeException(
                        "Error found: " + generalEx.getMessage() + " with causes from " + generalEx.getCause());
            }
        }

        //endregion

        //region Generating Resource Bundle service

        private @NotNull ResourceBundle getResourceBundle(final String filePath)
                throws IOException, MissingResourceException {

            FileInputStream fis = new FileInputStream(filePath);        //Placing the file into resource firstly

            return new PropertyResourceBundle(fis);                     //Generating Resource Bundle by fis
        }

        //endregion
    }
}