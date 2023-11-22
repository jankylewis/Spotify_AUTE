package se.model;

import java.io.Serializable;

public class UserInformationModel {         //This UserInformationModel was generated for Log-in and Sign-up functionalities

    private String userEmail;
    private String userPassword;
    private boolean isRemembered;

    //Sign-up flows
    private String displayedName;
    private int birthDate = -1;     //Forcing a default value
    private int birthMonth;
    private int birthYear = -1;     //Forcing a default value
    private String gender;

    public UserInformationModel(String usrEmail, String usrPwd, boolean usrRemembered) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.isRemembered = usrRemembered;
    }

    //region Being used for Sign-up flows
    public UserInformationModel(String usrEmail,
                                String usrPwd,
                                String displayedName,
                                int birthDate,
                                int birthMonth,
                                int birthYear,
                                String gender) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.displayedName = displayedName;
        this.birthDate = birthDate;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public UserInformationModel(String usrEmail) {
        this.userEmail = usrEmail;
    }

    public UserInformationModel(String usrEmail, String usrPwd) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
    }

    public UserInformationModel(String usrEmail,
                                String usrPwd,
                                String displayedName,
                                int birthMonth,
                                int birthYear,
                                String gender) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.displayedName = displayedName;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    //endregion

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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
