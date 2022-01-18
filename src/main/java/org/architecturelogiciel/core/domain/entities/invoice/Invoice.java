package org.architecturelogiciel.core.domain.entities.invoice;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.kernel.validator.ValidationInvoiceEngine;

public class Invoice {

    private InvoiceId invoiceId;
    private String name;
    private User user;
    private Boolean status;
    private int price;

    private Invoice(InvoiceId invoiceId,String name, User user, Boolean status, int price) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    public static Invoice of(InvoiceId invoiceId, String name, User user, Boolean status, int price){
        Invoice invoice = new Invoice(invoiceId, name, user, status, price);
        if (ValidationInvoiceEngine.getInstance().test(invoice)){
            return invoice;
        }
        throw new IllegalArgumentException("The invoice fiels are not valid");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public InvoiceId getId() {
        return invoiceId;
    }

    public void setInvoiceId(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }
}
