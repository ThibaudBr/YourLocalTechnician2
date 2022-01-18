package org.architecturelogiciel.core.domain.entities.user;

import org.architecturelogiciel.core.kernel.Entity;
import org.architecturelogiciel.core.kernel.validator.ValidationUserEngine;

public final class User implements Entity<UserId> {

    private UserId userId;
    private String username;
    private String mail;
    private String password;
    private UserType userType;

    private User(UserId userId, String username, String mail, String password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userType = userType;
    }

    public static User of(UserId userId, String username, String password, String mail, UserType userType) {
        User user = new User(userId, username, mail, password, userType);
        if (ValidationUserEngine.getInstance().test(user)){
            return user;
        }
        throw new IllegalArgumentException("The user fields are not valid.");
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
        return this.userType == UserType.CONTRACTOR;
    }

    public boolean isTradesman(){
        return this.userType == UserType.TRADESMAN;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    @Override
    public UserId getId() {
        return userId;
    }
}
