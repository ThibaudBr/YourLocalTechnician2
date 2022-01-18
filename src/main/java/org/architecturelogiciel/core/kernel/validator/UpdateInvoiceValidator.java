package org.architecturelogiciel.core.kernel.validator;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceRequest;

import java.security.InvalidParameterException;
import java.util.Objects;

public class UpdateInvoiceValidator {

    private UpdateInvoiceValidator() {
    }

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
