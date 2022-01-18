package org.architecturelogiciel.core.domain.services;

import org.architecturelogiciel.core.APIClient;

public abstract class Service<T> {
    protected final Class<T> type;
    protected final APIClient client;

    protected Service(Class<T> type, APIClient client) {
        this.type = type;
        this.client = client;
    }
}
