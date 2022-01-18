package org.architecturelogiciel.core.application.requests.user;

import org.architecturelogiciel.core.kernel.request.Request;

public final class UpdateUserRequest implements Request {

    private String username;
    private String mail;
    private String password;
    private String userType;

    private UpdateUserRequest(String username, String mail, String password, String userType) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userType = userType;
    }

    public static UpdateUserRequest of(String username, String mail, String password, String userType){
        return new UpdateUserRequest(username, mail, password, userType);
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
