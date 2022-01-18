package org.architecturelogiciel.core.kernel.event;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}

