package org.architecturelogiciel.core.application.event.invoice;

import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceStatusRequest;
import org.architecturelogiciel.core.kernel.event.ApplicationEvent;

public class UpdateInvoiceStatusEvent implements ApplicationEvent {

    public final UpdateInvoiceStatusRequest request;

    public UpdateInvoiceStatusEvent(UpdateInvoiceStatusRequest request) {
        this.request = request;
    }
}
