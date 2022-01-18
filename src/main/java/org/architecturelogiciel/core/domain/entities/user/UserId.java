package org.architecturelogiciel.core.domain.entities.user;

import org.architecturelogiciel.core.kernel.ValueObjectId;

public final class UserId implements ValueObjectId {
    private final int value;

    private UserId(int value) {
        this.value = value;
    }

    public static UserId of(int value) {
        return new UserId(value);
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return "" + value;
    }
}
