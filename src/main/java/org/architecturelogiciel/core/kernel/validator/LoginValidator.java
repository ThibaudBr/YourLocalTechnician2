package org.architecturelogiciel.core.kernel.validator;

import org.architecturelogiciel.core.application.requests.user.LoginRequest;

import java.security.InvalidParameterException;
import java.util.Objects;

public class LoginValidator {
    public static void loginValidator(LoginRequest loginRequest) throws InvalidParameterException {
        validateUsername(loginRequest.getUsername());
        validatePassword(loginRequest.getPassword());
    }

    public static void validatePassword(String password) throws InvalidParameterException {
        Objects.requireNonNull(password);

        if (password.trim().equals("")){
            throw new InvalidParameterException();
        }
    }

    public static void validateUsername(String username) throws InvalidParameterException {
        Objects.requireNonNull(username);

        if (username.trim().equals("")){
            throw new InvalidParameterException();
        }
    }
}
