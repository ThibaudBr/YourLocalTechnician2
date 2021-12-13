package org.architecturelogiciel.core.validator;

import org.architecturelogiciel.core.models.user.User;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUserEngine implements Predicate<User> {

    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    private final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{7,21}$");

    private final Pattern VALID_USER_USERNAME = Pattern.compile("^{3,15}");

    private static final ValidationUserEngine INSTANCE = new ValidationUserEngine();

    private ValidationUserEngine() { }

    public static ValidationUserEngine getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(User user) {
        return validatePassword(user.getPassword()) && validateMail(user.getMail()) && validateUsername(user.getUsername());
    }

    private boolean validatePassword(String password) {
        Objects.requireNonNull(password);

        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    private boolean validateMail(String mail) {
        Objects.requireNonNull(mail);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        return matcher.find();
    }

    private boolean validateUsername(String username) {

        Objects.requireNonNull(username);

        Matcher matcher = VALID_USER_USERNAME.matcher(username);
        return matcher.find();
    }
}
