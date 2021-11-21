package org.architecturelogiciel.core.validator;

import org.architecturelogiciel.core.requests.SubscribeRequest;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.regex.Pattern;

public class SubscribeValidator {
    public static void subscribeValidator(SubscribeRequest subscribeRequest) throws InvalidParameterException {
        validateUsername(subscribeRequest.getUsername());
        validateMail(subscribeRequest.getMail());
        validatePassword(subscribeRequest.getPassword());
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

        if (mail.trim().equals("") || !pattern.matcher(mail).matches()){
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
