package my.edu.umk.pams.intake.web.module.account.vo;

/**
 */
public class UsernameChange {
    private String currentEmail;
    private String newEmail;

    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
