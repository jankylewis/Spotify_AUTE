package se.model;

public class UserInformationModel {         //This UserInformationModel was generated for Log-in and Sign-up functionalities

    private String userEmail;
    private String userPassword;
    private boolean isRemembered;

    //Sign-up flows
    private String displayedName;
    private int birthDate;
    private int birthMonth;
    private int birthYear;

    public UserInformationModel(String usrEmail, String usrPwd, boolean usrRemembered) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.isRemembered = usrRemembered;
    }

    //Being used for Sign-up flows
    public UserInformationModel(String usrEmail,
                                String usrPwd,
                                String displayedName,
                                int birthDate,
                                int birthMonth,
                                int birthYear) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.displayedName = displayedName;
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public void setUserEmail(String usrEmail) {
        this.userEmail = usrEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPassword(String usrPwd) {
        this.userPassword = usrPwd;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserRemembered(boolean usrRemembered) {
        this.isRemembered = usrRemembered;
    }

    public boolean getUserRemembered() {
        return isRemembered;
    }

    public void setDisplayedName(String displayedName) {
        this.displayedName = displayedName;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
