package se.model;

public class UserInformationModel {

    private String userEmail;
    private String userPassword;
    private boolean isRemembered;

    public UserInformationModel(String usrEmail, String usrPwd, boolean usrRemembered) {
        this.userEmail = usrEmail;
        this.userPassword = usrPwd;
        this.isRemembered = usrRemembered;
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
}
