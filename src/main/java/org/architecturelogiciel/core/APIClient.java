package org.architecturelogiciel.core;

import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.requests.LoginRequest;
import org.architecturelogiciel.core.requests.SubscribeRequest;
import org.architecturelogiciel.core.services.AuthService;
import org.architecturelogiciel.core.services.InvoiceService;
import org.architecturelogiciel.core.services.UsersService;

public class APIClient {

    private final AuthService authService;
    private final UsersService usersService;
    private final InvoiceService invoiceService;
    private User user;

    public APIClient() {

        authService = new AuthService(this);
        usersService = new UsersService(this);
        invoiceService = new InvoiceService(this);
    }

    public void connect(LoginRequest loginRequest){
        this.user = authService.login(loginRequest);
    }

    public void subscribe(SubscribeRequest subscribeRequest){
        this.user = authService.subscribe(subscribeRequest);
    }

    public AuthService getAuthService() {
        return authService;
    }

    public User getUser() {
        return user;
    }

    public void disconnect() {
        user = null;
    }

    public UsersService getUsersService() {
        return usersService;
    }

    public InvoiceService getInvoiceService() {
        return invoiceService;
    }
}
