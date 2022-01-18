package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.kernel.request.Request;

public final class UpdateInvoiceRequest implements Request {

    private InvoiceId invoiceId;
    private String name;
    private User user;
    private Boolean status;
    private int price;

    private UpdateInvoiceRequest(int id, String name, User user, Boolean status, int price) {
        this.invoiceId = InvoiceId.of(id);
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    public static UpdateInvoiceRequest of(int id, String name, User user, Boolean status, int price){
        return new UpdateInvoiceRequest(id, name, user, status, price);
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

    public void setId(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }
}
