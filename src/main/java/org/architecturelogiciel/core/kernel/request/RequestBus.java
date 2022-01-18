package org.architecturelogiciel.core.kernel.request;

public interface RequestBus {
    <C, R> R send(C request);
}
