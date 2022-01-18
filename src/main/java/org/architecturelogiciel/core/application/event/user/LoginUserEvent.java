package org.architecturelogiciel.core.application.event.user;

import org.architecturelogiciel.core.application.requests.user.LoginRequest;
import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class LoginUserEvent implements ApplicationEvent {
    public final LoginRequest loginRequest;

    public LoginUserEvent(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
}
