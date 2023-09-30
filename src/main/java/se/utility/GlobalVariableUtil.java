package se.utility;

import se.utility.fileReader.BaseFileReader;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class GlobalVariableUtil extends BaseFileReader {
    private static String key;                  //For HashMap initializations

    //Nested class needs to be declared in static state

    //region Variables come from environment.properties
    public static class Environment {

        //region Introducing global variables

        private String filePath = "./src/main/java/se/globalVariable/environment.properties";   //Providing environment's path
        private ResourceReader resourceReader = new ResourceReader();
        public String baseUrl = resourceReader.getPropertyFromGV("base_url", filePath);
        public String publicUrl = resourceReader.getPropertyFromGV("public_url", filePath);
        public String endPointLocalization = resourceReader.getPropertyFromGV("end_point_localization", filePath);

        //endregion

    }

    //endregion

    //region Variables come from browser_configuration.properties

    public static class BrowserConfiguration {

        //region Introducing global variables

        private String filePath = "./src/main/java/se/globalVariable/browser_configuration.properties";   //Providing browser config's path
        private ResourceReader resourceReader = new ResourceReader();

        public String browserType = resourceReader.getPropertyFromGV("browser_type", filePath);
        public boolean isHeadless = Boolean.parseBoolean(resourceReader.getPropertyFromGV("is_headless", filePath));

//        public HashMap browserType = new HashMap() {{
//            put(key = "browser_type", resourceReader.getPropertyFromGV(key, filePath));
//        }};
//        public HashMap isHeadless = new HashMap() {{
//            put(key = "is_headless", Boolean.parseBoolean(resourceReader.getPropertyFromGV(key, filePath)));
//        }};

        //endregion

    }

    //endregion

    //region Variables come from user_credential.properties

    public static class UserCredential {

        //region Introducing global variables

        private String filePath = "./src/main/java/se/globalVariable/user_credential.properties";   //Providing user infor's path
        private ResourceReader resourceReader = new ResourceReader();

        public String userNation = resourceReader.getPropertyFromGV("user_nation", filePath);
        public String userDob = resourceReader.getPropertyFromGV("user_dob", filePath);
        public String userEmail = resourceReader.getPropertyFromGV("user_email", filePath);
        public String userPassword = resourceReader.getPropertyFromGV("user_password", filePath);
        public Boolean isRemembered = Boolean.parseBoolean(resourceReader.getPropertyFromGV("is_remembered", filePath));

        //endregion
    }

    //endregion

    //region Adjusting Global Variable

    public GlobalVariableUtil updatePropertyFromGV() {

        return this;
    }

    //endregion

    //region Restoring the Global Variable

    public GlobalVariableUtil restorePropertyFromGV() {

        return this;
    }

    //endregion
}
