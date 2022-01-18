package org.architecturelogiciel.core.kernel.exception;

import org.architecturelogiciel.core.domain.entities.user.UserId;

public class NoSuchEntityException extends RuntimeException{

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withContractor(UserId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withTrandsmanId(UserId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
