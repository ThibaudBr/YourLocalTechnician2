package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.kernel.event.EventListener;

public class UpdateInvoiceEventListener implements EventListener<UpdateInvoiceEvent> {
    @Override
    public void listenTo(UpdateInvoiceEvent event) {
        System.out.println("listening UpdateInvoiceEventListener.");
        System.out.println("Invoice " + event.request.getId().getValue() + " have been update");
    }
}
