package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.application.event.invoice.UpdateInvoiceStatusEvent;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.InvoiceService;

public class UpdateInvoiceStatusRequestHandler implements RequestHandler<UpdateInvoiceStatusRequest, InvoiceId> {

    private final InvoiceService invoiceService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static UpdateInvoiceStatusRequestHandler of(InvoiceService invoiceService, EventDispatcher<Event> eventEventDispatcher){
        return new UpdateInvoiceStatusRequestHandler(invoiceService, eventEventDispatcher);
    }

    private UpdateInvoiceStatusRequestHandler(InvoiceService invoiceService, EventDispatcher<Event> eventEventDispatcher) {
        this.invoiceService = invoiceService;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public InvoiceId handle(UpdateInvoiceStatusRequest request) {
        final InvoiceId invoiceId = invoiceService.findById(request.getId()).getId();
        invoiceService.updateStatus(request);
        eventEventDispatcher.dispatch(new UpdateInvoiceStatusEvent(request));
        return invoiceId;
    }
}
