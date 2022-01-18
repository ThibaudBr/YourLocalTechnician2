package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class UpdateInvoiceStatusEventListener implements EventListener<UpdateInvoiceStatusEvent> {
    @Override
    public void listenTo(UpdateInvoiceStatusEvent event) {
        System.out.println("listening UpdateInvoiceStatusEventListener.");
        System.out.println("Invoice " + event.request.getId().getValue() + " have been paid ");
    }
}
