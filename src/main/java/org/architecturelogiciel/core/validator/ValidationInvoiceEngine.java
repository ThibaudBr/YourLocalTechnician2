package org.architecturelogiciel.core.validator;

import org.architecturelogiciel.core.models.invoice.Invoice;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationInvoiceEngine implements Predicate<Invoice> {

    private final Pattern VALID_INVOICE_NAME = Pattern.compile("^{3,15}");

    private static final ValidationInvoiceEngine INSTANCE = new ValidationInvoiceEngine();

    public ValidationInvoiceEngine() {
    }

    public static ValidationInvoiceEngine getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(Invoice invoice) {
        return validateName(invoice.getName()) && validatePrice(invoice.getPrice());
    }

    private boolean validatePrice(int price) {
        if (price < 0){
            throw new IllegalArgumentException("Price can't be inferior to 0");
        }
        return true;
    }


    private boolean validateName(String name) {
        Objects.requireNonNull(name);

        Matcher matcher = VALID_INVOICE_NAME.matcher(name);
        return matcher.find();
    }
}
