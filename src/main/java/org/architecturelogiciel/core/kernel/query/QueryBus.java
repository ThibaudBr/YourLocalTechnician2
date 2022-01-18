package org.architecturelogiciel.core.kernel.query;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}