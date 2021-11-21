package org.architecturelogiciel.core.validator;

import org.architecturelogiciel.core.requests.UpdateInvoiceStatusRequest;

import java.util.Objects;

public class UpdateInvoiceStatusValidator {

    public static void updateInvoiceStatusValidator(UpdateInvoiceStatusRequest updateInvoiceStatusRequest){
        validateStatus(updateInvoiceStatusRequest.getStatus());
    }

    private static void validateStatus(boolean status) {
        Objects.requireNonNull(status);
    }
}
