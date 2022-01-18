package org.architecturelogiciel.core.kernel.request;

import org.architecturelogiciel.core.kernel.exception.NoSuchRequestException;

import java.util.Map;

public class SimpleRequestBus implements RequestBus {
    private final Map<Class<? extends Request>, RequestHandler> dataMap;

    public SimpleRequestBus(Map<Class<? extends Request>, RequestHandler> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public <C, R> R send(C request) {
        return dispatch(request);
    }

    private <C, R> R dispatch(C request) {
        final RequestHandler requestHandler = dataMap.get(request.getClass());
        if (requestHandler == null) {
            throw NoSuchRequestException.withGetClass((Request) request);
        }

        return (R) requestHandler.handle(request);
    }
}