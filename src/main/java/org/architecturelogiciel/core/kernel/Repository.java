package org.architecturelogiciel.core.kernel;

import java.util.List;

public interface Repository<VOID, E> {

    E findById(VOID id);

    void delete(VOID id);

    void save(E e);


    List<E> findAll();
}
