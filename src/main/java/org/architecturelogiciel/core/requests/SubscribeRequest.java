package org.architecturelogiciel.core.requests;

public class SubscribeRequest {
    private String username;
    private String mail;
    private String password;
    private String userType;

    public SubscribeRequest(String username, String mail, String password, String userType) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userType = userType;
    }

    public SubscribeRequest() {
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
