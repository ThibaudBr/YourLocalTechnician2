package org.architecturelogiciel.core;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.infrastructure.persistence.InvoiceLocalRepository;
import org.architecturelogiciel.core.infrastructure.persistence.UserLocalRepository;
import org.architecturelogiciel.core.application.requests.user.LoginRequest;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.domain.services.AuthService;
import org.architecturelogiciel.core.domain.services.InvoiceService;
import org.architecturelogiciel.core.domain.services.UsersService;

public class APIClient {

    private final AuthService authService;
    private final UsersService usersService;
    private final InvoiceService invoiceService;
    private final UserLocalRepository userLocalRepository;
    private final InvoiceLocalRepository invoiceLocalRepository;
    private User user;

    public APIClient() {

        userLocalRepository = new UserLocalRepository();
        invoiceLocalRepository = new InvoiceLocalRepository();
        invoiceService = new InvoiceService(this);
        authService = new AuthService(this);
        usersService = new UsersService(this);
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

    public UserLocalRepository getUserRepository() {
        return userLocalRepository;
    }

    public InvoiceLocalRepository getInvoiceRepository() {
        return invoiceLocalRepository;
    }
}
