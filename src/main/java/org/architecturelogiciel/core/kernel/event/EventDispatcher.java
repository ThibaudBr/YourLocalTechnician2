package org.architecturelogiciel.core.kernel.event;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
