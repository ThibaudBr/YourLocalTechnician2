package org.architecturelogiciel.core.configuration;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.application.event.invoice.*;
import org.architecturelogiciel.core.application.event.user.*;
import org.architecturelogiciel.core.application.requests.invoice.*;
import org.architecturelogiciel.core.application.requests.user.*;
import org.architecturelogiciel.core.domain.repository.InvoiceRepository;
import org.architecturelogiciel.core.domain.repository.UserRepository;
import org.architecturelogiciel.core.domain.services.AuthService;
import org.architecturelogiciel.core.domain.services.InvoiceService;
import org.architecturelogiciel.core.domain.services.UsersService;
import org.architecturelogiciel.core.infrastructure.event.DefaultEventDispatcher;
import org.architecturelogiciel.core.infrastructure.persistence.InvoiceLocalRepository;
import org.architecturelogiciel.core.infrastructure.persistence.UserLocalRepository;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.event.EventListener;
import org.architecturelogiciel.core.kernel.request.Request;
import org.architecturelogiciel.core.kernel.request.RequestBus;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.kernel.request.SimpleRequestBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SpringConfiguration {

    private APIClient client = new APIClient();
    @Bean
    public UserRepository UserRepository() {
        return new UserLocalRepository();
    }

    @Bean
    public InvoiceRepository InvoiceRepository(){
        return new InvoiceLocalRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateInvoiceEvent.class, List.of(new CreateInvoiceEventListener()));
        listenerMap.put(UpdateInvoiceEvent.class, List.of(new UpdateInvoiceEventListener()));
        listenerMap.put(UpdateInvoiceStatusEvent.class, List.of(new UpdateInvoiceStatusEventListener()));
        listenerMap.put(LoginUserEvent.class, List.of(new LoginUserEventListener()));
        listenerMap.put(SubscribeUserEvent.class, List.of(new SubscribeUserEventListener()));
        listenerMap.put(UpdateUserEvent.class, List.of(new UpdateUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public RequestBus requestBusTrandsman() {
        final Map<Class<? extends Request>, RequestHandler> requestHandlerMap = new HashMap<>();
        requestHandlerMap.put(CreateInvoiceRequest.class, CreateInvoiceRequestHandler.of(new InvoiceService(client), eventEventDispatcher()));
        requestHandlerMap.put(UpdateInvoiceRequest.class, UpdateInvoiceRequestHandler.of(new InvoiceService(client), eventEventDispatcher()));
        requestHandlerMap.put(UpdateInvoiceStatusRequest.class, UpdateInvoiceStatusRequestHandler.of(new InvoiceService(client), eventEventDispatcher()));
        requestHandlerMap.put(LoginRequest.class, LoginRequestHandler.of(new UsersService(client), new AuthService(client), eventEventDispatcher()));
        requestHandlerMap.put(SubscribeRequest.class, SubscribeUserRequestHandler.of( new AuthService(client), new UsersService(client), eventEventDispatcher()));
        requestHandlerMap.put(UpdateUserRequest.class, UpdateUserRequestHandler.of(new UsersService(client), eventEventDispatcher()));
        return new SimpleRequestBus(requestHandlerMap);
    }

}
