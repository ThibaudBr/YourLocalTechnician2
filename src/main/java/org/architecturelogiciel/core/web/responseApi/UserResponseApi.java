package org.architecturelogiciel.core.web.responseApi;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.domain.entities.user.UserType;
import org.architecturelogiciel.core.kernel.validator.ValidationUserEngine;

public final class UserResponseApi {


    private UserId userId;
    private String username;
    private String mail;
    private String password;
    private UserType userType;

    public static UserResponseApi of(UserId userId, String username, String mail, String password, UserType userType){
        ValidationUserEngine validationUserEngine = ValidationUserEngine.getInstance();
        User user = User.of(userId, username, mail, password, userType);
        validationUserEngine.test(user);
        return new UserResponseApi(userId, username, mail, password, userType);

    }

    public UserResponseApi(UserId userId, String username, String mail, String password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserResponseApi{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
