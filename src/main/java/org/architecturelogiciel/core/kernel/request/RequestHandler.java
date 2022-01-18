package org.architecturelogiciel.core.kernel.request;

public interface RequestHandler<C, R> {
    R handle(C request);
}
