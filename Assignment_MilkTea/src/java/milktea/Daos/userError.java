/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Daos;

/**
 *
 * @author DELL
 */
public class userError {
    private int userIDError;
    private String userNameError;
    private String passWordError;
    private String addressError;
    private String phoneError;
    private String roleIDError;

    public userError() {
    }

    public userError(int userIDError, String userNameError, String passWordError, String addressError, String phoneError, String roleIDError) {
        this.userIDError = userIDError;
        this.userNameError = userNameError;
        this.passWordError = passWordError;
        this.addressError = addressError;
        this.phoneError = phoneError;
        this.roleIDError = roleIDError;
    }

    public int getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(int userIDError) {
        this.userIDError = userIDError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPassWordError() {
        return passWordError;
    }

    public void setPassWordError(String passWordError) {
        this.passWordError = passWordError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }
    
}
