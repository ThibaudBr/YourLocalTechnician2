package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class SubscribeUserEventListener implements EventListener<SubscribeUserEvent> {
    @Override
    public void listenTo(SubscribeUserEvent event) {
        System.out.println("listening SubscribeUserEventListener.");
        System.out.println("User : " + event.request.getUsername() + " subscribe");
    }
}
