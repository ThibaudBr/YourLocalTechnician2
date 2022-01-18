package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class CreateInvoiceEvent implements ApplicationEvent {
    public final int price;


    public CreateInvoiceEvent(int price) {
        this.price = price;
    }
}
