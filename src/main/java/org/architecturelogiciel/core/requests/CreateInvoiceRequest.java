package org.architecturelogiciel.core.requests;

import org.architecturelogiciel.core.models.User;

public class CreateInvoiceRequest {

    private String name;
    private User user;
    private Boolean status;
    private int price;

    public CreateInvoiceRequest(String name, User user, Boolean status, int price) {
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    public CreateInvoiceRequest() {
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
