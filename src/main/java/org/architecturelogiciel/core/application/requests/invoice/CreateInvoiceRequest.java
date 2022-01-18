package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.kernel.request.Request;

public final class CreateInvoiceRequest implements Request {

    private String name;
    private User user;
    private Boolean status;
    private int price;

    private CreateInvoiceRequest(String name, User user, Boolean status, int price) {
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    private CreateInvoiceRequest() {
    }

    public static CreateInvoiceRequest of(String name, User user, Boolean status, int price) {

        return new CreateInvoiceRequest(name, user, status, price);
    }

    public static CreateInvoiceRequest of() {
        return new CreateInvoiceRequest();
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
}
