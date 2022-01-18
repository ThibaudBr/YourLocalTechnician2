package org.architecturelogiciel.core.web.responseApi;

import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.kernel.validator.ValidationInvoiceEngine;

public final class InvoiceResponseApi {

    private InvoiceId invoiceId;
    private String name;
    private User user;
    private Boolean status;
    private int price;

    private InvoiceResponseApi(InvoiceId invoiceId,String name, User user, Boolean status, int price) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    public static InvoiceResponseApi of(InvoiceId invoiceId, String name, User user, Boolean status, int price){
        Invoice invoice = Invoice.of(invoiceId, name, user, status, price);
        if (ValidationInvoiceEngine.getInstance().test(invoice)){
            return new InvoiceResponseApi(invoiceId, name, user, status, price);
        }
        throw new IllegalArgumentException("The invoice fiels are not valid");
    }
}
