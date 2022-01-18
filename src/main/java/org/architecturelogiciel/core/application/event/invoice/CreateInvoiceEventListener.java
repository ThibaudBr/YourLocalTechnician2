package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class CreateInvoiceEventListener implements EventListener<CreateInvoiceEvent> {
    @Override
    public void listenTo(CreateInvoiceEvent event) {
        System.out.println("listening CreateInvoiceEventListener.");
        System.out.println("Member need to pay :"+ event.price);
    }
}
