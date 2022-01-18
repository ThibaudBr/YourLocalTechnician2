package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.application.event.invoice.CreateInvoiceEvent;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.kernel.event.Event;
import org.architecturelogiciel.core.kernel.event.EventDispatcher;
import org.architecturelogiciel.core.kernel.request.RequestHandler;
import org.architecturelogiciel.core.domain.services.InvoiceService;

public class CreateInvoiceRequestHandler implements RequestHandler<CreateInvoiceRequest, InvoiceId> {

    private final InvoiceService invoiceService;
    private final EventDispatcher<Event> eventEventDispatcher;

    public static CreateInvoiceRequestHandler of(InvoiceService invoiceService, EventDispatcher<Event> eventEventDispatcher){
        return new CreateInvoiceRequestHandler(invoiceService, eventEventDispatcher);
    }

    private CreateInvoiceRequestHandler(InvoiceService invoiceRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.invoiceService = invoiceRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public InvoiceId handle(CreateInvoiceRequest request) {
        invoiceService.createInvoice(request);
        eventEventDispatcher.dispatch(new CreateInvoiceEvent(request.getPrice()));
        return null;
    }
}
