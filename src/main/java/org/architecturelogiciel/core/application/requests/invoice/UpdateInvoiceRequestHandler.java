package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.application.event.invoice.UpdateInvoiceEvent;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.InvoiceService;

public class UpdateInvoiceRequestHandler implements RequestHandler<UpdateInvoiceRequest, InvoiceId> {

    private final InvoiceService invoiceService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static UpdateInvoiceRequestHandler of(InvoiceService invoiceService, EventDispatcher<Event> eventEventDispatcher){
        return new UpdateInvoiceRequestHandler(invoiceService, eventEventDispatcher);
    }

    private UpdateInvoiceRequestHandler(InvoiceService invoiceService, EventDispatcher<Event> eventEventDispatcher) {
        this.invoiceService = invoiceService;
        this.eventEventDispatcher = eventEventDispatcher;
    }



    @Override
    public InvoiceId handle(UpdateInvoiceRequest request) {
        final InvoiceId invoiceId = invoiceService.findById(request.getId()).getId();
        invoiceService.updateInvoice(request);
        eventEventDispatcher.dispatch(new UpdateInvoiceEvent(request));
        return invoiceId;
    }
}
