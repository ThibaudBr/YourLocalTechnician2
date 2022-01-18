package org.architecturelogiciel.core.kernel.validator;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;

import java.security.InvalidParameterException;
import java.util.Objects;

public class CreateInvoiceValidator {

    private CreateInvoiceValidator() {
    }

    public static void invoiceValidator(CreateInvoiceRequest createInvoiceRequest) throws InvalidParameterException {
        validateName(createInvoiceRequest.getName());
        validateUser(createInvoiceRequest.getUser());
        validateStatus(createInvoiceRequest.getStatus());
        validatePrice(createInvoiceRequest.getPrice());
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
