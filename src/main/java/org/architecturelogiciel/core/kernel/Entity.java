package org.architecturelogiciel.core.kernel;

public interface Entity<VOID extends ValueObjectId> {
    VOID getId();
}