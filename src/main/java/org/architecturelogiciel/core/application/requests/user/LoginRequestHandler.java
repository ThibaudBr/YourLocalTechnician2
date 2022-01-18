package org.architecturelogiciel.core.application.requests.user;

import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.AuthService;
import org.architecturelogiciel.core.domain.services.UsersService;

public class LoginRequestHandler implements RequestHandler<LoginRequest, UserId> {

    private final UsersService usersService;
    private final AuthService authService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static LoginRequestHandler of(UsersService usersService, AuthService authService, EventDispatcher<Event> eventEventDispatcher){
        return new LoginRequestHandler(usersService, authService, eventEventDispatcher);
    }

    private LoginRequestHandler(UsersService usersService, AuthService authService, EventDispatcher<Event> eventEventDispatcher) {
        this.usersService = usersService;
        this.authService = authService;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public UserId handle(LoginRequest request) {
        authService.login(request);
        return usersService.getUserRepository().findByUsername(request.getUsername()).getId();
    }
}
