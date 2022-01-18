package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceRequest;
import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class UpdateInvoiceEvent implements ApplicationEvent {
    public final UpdateInvoiceRequest request;

    public UpdateInvoiceEvent(UpdateInvoiceRequest request) {
        this.request = request;
    }
}
