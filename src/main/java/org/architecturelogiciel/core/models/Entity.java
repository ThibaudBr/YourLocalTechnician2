package org.architecturelogiciel.core.models;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Entity {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private int id;

    public int getId() { return id;}
    public void setId(){
        this.id = ID_GENERATOR.getAndIncrement();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getId(), entity.getId());
    }

}
