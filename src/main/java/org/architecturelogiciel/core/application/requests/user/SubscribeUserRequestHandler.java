package org.architecturelogiciel.core.application.requests.user;

import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.AuthService;
import org.architecturelogiciel.core.domain.services.UsersService;

public class SubscribeUserRequestHandler implements RequestHandler<SubscribeRequest, UserId> {

    private final AuthService authService;
    private final UsersService usersService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static SubscribeUserRequestHandler of(AuthService authService, UsersService usersService, EventDispatcher<Event> eventEventDispatcher){
        return new SubscribeUserRequestHandler(authService, usersService, eventEventDispatcher);
    }

    public SubscribeUserRequestHandler(AuthService authService, UsersService usersService, EventDispatcher<Event> eventEventDispatcher) {
        this.authService = authService;
        this.usersService = usersService;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public UserId handle(SubscribeRequest request) {
        authService.subscribe(request);
        return usersService.getUserRepository().findByUsername(request.getUsername()).getId();
    }
}
