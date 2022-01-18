package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class UpdateUserEventListener implements EventListener<UpdateUserEvent> {
    @Override
    public void listenTo(UpdateUserEvent event) {
        System.out.println("listening UpdateUserEventListener.");
        System.out.println("User " + event.request.getUsername() + " have been update");
    }
}
