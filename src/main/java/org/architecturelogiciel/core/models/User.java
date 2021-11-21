package org.architecturelogiciel.core.models;

import static org.architecturelogiciel.core.models.UserType.CONTRACTOR;
import static org.architecturelogiciel.core.models.UserType.TRADESMAN;

public class User extends Entity{

    private String username;
    private String mail;
    private String password;
    private UserType userType;

    public User(String username, String mail, String password, UserType userType) {
        super();
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userType = userType;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isContractor(){
        return this.userType == CONTRACTOR;
    }

    public boolean isTradesman(){
        return this.userType == TRADESMAN;
    }
}
