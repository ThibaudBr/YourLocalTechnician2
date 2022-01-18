package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class LoginUserEventListener implements EventListener<LoginUserEvent> {
    @Override
    public void listenTo(LoginUserEvent event) {
        System.out.println("listening UpdateInvoiceEventListener.");
        System.out.println("User : " + event.loginRequest.getUsername() + " try to login");
    }
}
