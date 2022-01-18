package org.architecturelogiciel.core.application.requests.user;

import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.UsersService;

public class UpdateUserRequestHandler implements RequestHandler<UpdateUserRequest, UserId> {

    private final UsersService usersService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static UpdateUserRequestHandler of(UsersService usersService, EventDispatcher<Event> eventEventDispatcher){
        return new UpdateUserRequestHandler(usersService, eventEventDispatcher);
    }

    private UpdateUserRequestHandler(UsersService usersService, EventDispatcher<Event> eventEventDispatcher) {
        this.usersService = usersService;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public UserId handle(UpdateUserRequest request) {
        usersService.updateUser(request);
        return usersService.getUserRepository().findByUsername(request.getUsername()).getId();
    }
}
