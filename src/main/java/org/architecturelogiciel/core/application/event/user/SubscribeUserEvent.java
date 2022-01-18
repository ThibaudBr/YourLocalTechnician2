package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class SubscribeUserEvent implements ApplicationEvent {
    public final SubscribeRequest request;

    public SubscribeUserEvent(SubscribeRequest request) {
        this.request = request;
    }
}
