package org.architecturelogiciel.core.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.models.Entity;

public abstract class Service<T extends Entity> {
    protected final Class<T> type;
    protected final APIClient client;

    protected Service(Class<T> type, APIClient client) {
        this.type = type;
        this.client = client;
    }
}
