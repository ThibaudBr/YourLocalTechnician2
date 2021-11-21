package org.architecturelogiciel.core.models;

public class Invoice extends Entity{

    private String name;
    private User user;
    private Boolean status;
    private int price;

    public Invoice(String name, User user, Boolean status, int price) {
        super();
        this.name = name;
        this.user = user;
        this.status = status;
        this.price = price;
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
