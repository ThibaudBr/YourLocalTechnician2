package org.architecturelogiciel.core.validator;

import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.requests.UpdateInvoiceRequest;

import java.security.InvalidParameterException;
import java.util.Objects;

public class UpdateInvoiceValidator {

    public static void updateInvoiceValidator(UpdateInvoiceRequest updateInvoiceRequest){
        validateName(updateInvoiceRequest.getName());
        validateUser(updateInvoiceRequest.getUser());
        validateStatus(updateInvoiceRequest.getStatus());
        validatePrice(updateInvoiceRequest.getPrice());
    }

    private static void validatePrice(int price) {
        if (price < 0 ){
            throw new InvalidParameterException();
        }

    }

    private static void validateStatus(Boolean status) {
        Objects.requireNonNull(status);

    }

    private static void validateUser(User user) {
        Objects.requireNonNull(user);

    }

    private static void validateName(String name) {
        Objects.requireNonNull(name);

        if (name.trim().equals("")){
            throw new InvalidParameterException();
        }
    }
}
