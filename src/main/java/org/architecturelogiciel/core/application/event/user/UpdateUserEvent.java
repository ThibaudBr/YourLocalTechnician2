package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.application.requests.user.UpdateUserRequest;
import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class UpdateUserEvent implements ApplicationEvent {
    public final UpdateUserRequest request;

    public UpdateUserEvent(UpdateUserRequest request) {
        this.request = request;
    }
}
