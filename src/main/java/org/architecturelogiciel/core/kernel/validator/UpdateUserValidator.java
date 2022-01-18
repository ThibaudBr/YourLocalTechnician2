package org.architecturelogiciel.core.kernel.validator;

import org.architecturelogiciel.core.application.requests.user.UpdateUserRequest;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.regex.Pattern;

public class UpdateUserValidator {

    public static void updateUserValidator(UpdateUserRequest updateUserRequest){
        validateUsername(updateUserRequest.getUsername());
        validateMail(updateUserRequest.getMail());
        validatePassword(updateUserRequest.getPassword());
        validateUserType(updateUserRequest.getUserType());
    }

    private static void validateUserType(String userType) {
        Objects.requireNonNull(userType);
    }

    private static void validatePassword(String password) {
        Objects.requireNonNull(password);

        if (password.trim().equals("")){
            throw new InvalidParameterException();
        }
    }

    private static void validateMail(String mail) {
        Objects.requireNonNull(mail);

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        if (mail.trim().equals("") || pattern.matcher(mail).matches()){
            throw new InvalidParameterException();
        }
    }

    private static void validateUsername(String username) {

        Objects.requireNonNull(username);

        if (username.trim().equals("")){
            throw new InvalidParameterException();
        }
    }


}
