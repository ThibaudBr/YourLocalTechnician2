package org.architecturelogiciel.core.domain.entities.invoice;

import org.architecturelogiciel.core.kernel.ValueObjectId;

public final class InvoiceId implements ValueObjectId {
    private final int value;

    private InvoiceId(int value) {
        this.value = value;
    }

    public static InvoiceId of(int value) {
        return new InvoiceId(value);
    }

    public String getValue() { return String.valueOf(value);}
}
