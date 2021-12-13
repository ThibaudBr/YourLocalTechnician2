package org.architecturelogiciel.core.models.invoice;

public final class InvoiceId {
    private final int value;

    private InvoiceId(int value) {
        this.value = value;
    }

    public static InvoiceId of(int value) {
        return new InvoiceId(value);
    }

    public String getValue() { return String.valueOf(value);}
}
