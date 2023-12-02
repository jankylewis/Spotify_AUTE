package se.utility;

import se.utility.fileReader.BaseFileReader;

public class GlobalVariableUtil extends BaseFileReader {

    //Nested class needs to be declared in static state

    //region Variables come from environment.properties
    public static class Environment {

        //region Introducing global variables

        //Providing environment's path
        private static final String FILEPATH = "./src/main/java/se/globalVariable/environment.properties";
        private static final ResourceReader RESOURCE_READER = new ResourceReader();
        public static final String BASE_URL = RESOURCE_READER.getPropertyFromGV("base_url", FILEPATH);
        public static final String PUBLIC_URL = RESOURCE_READER.getPropertyFromGV("public_url", FILEPATH);
        public static final String END_POINT_LOCALIZATION = RESOURCE_READER.getPropertyFromGV("end_point_localization", FILEPATH);

        //endregion

    }

    //endregion

    //region Variables come from browser_configuration.properties

    public static class BrowserConfiguration {

        //region Introducing global variables

        //Providing browser config's path
        private static final String FILE_PATH = "./src/main/java/se/globalVariable/browser_configuration.properties";
        public static final String BROWSER_TYPE = ResourceReader.getPropertyFromGV("browser_type", FILE_PATH);
        public static final Boolean HEADLESS = Boolean.parseBoolean(ResourceReader.getPropertyFromGV("is_headless", FILE_PATH));

        //endregion

    }

    //endregion

    //region Variables come from user_credential.properties

    public static class UserCredential {

        //region Introducing global variables

        //Providing user infor's path
        private static final String FILE_PATH = "./src/main/java/se/globalVariable/user_credential.properties";
        public static final String USER_NATION = ResourceReader.getPropertyFromGV("user_nation", FILE_PATH);
        public static final String USER_DOB = ResourceReader.getPropertyFromGV("user_dob", FILE_PATH);
        public static final String USER_EMAIL = ResourceReader.getPropertyFromGV("user_email", FILE_PATH);
        public static final String USER_PASSWORD = ResourceReader.getPropertyFromGV("user_password", FILE_PATH);
        public static final Boolean REMEMBERED = Boolean.parseBoolean(ResourceReader.getPropertyFromGV("is_remembered", FILE_PATH));
        public static final String USER_GENDER = ResourceReader.getPropertyFromGV("user_gender", FILE_PATH);

        //endregion
    }

    //endregion

    //region Variables come from script_configuration.properties

    public static class ScriptConfiguration {

        //region Introducing global variables

        //Providing user infor's path
        private static final String FILE_PATH = "./src/main/java/se/globalVariable/script_configuration.properties";
        public static final Boolean RECORDED = Boolean.parseBoolean(ResourceReader.getPropertyFromGV("is_recorded", FILE_PATH));
        public static final Boolean SCREENSHOTTED = Boolean.parseBoolean(ResourceReader.getPropertyFromGV("is_screenshotted", FILE_PATH));

        //endregion

    }

    //endregion
}
