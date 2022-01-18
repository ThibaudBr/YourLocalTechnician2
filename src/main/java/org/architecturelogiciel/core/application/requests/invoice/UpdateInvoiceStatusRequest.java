package org.architecturelogiciel.core.application.requests.invoice;

import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.kernel.request.Request;

public final class UpdateInvoiceStatusRequest implements Request {

    private InvoiceId invoiceId;
    private boolean status;

    private UpdateInvoiceStatusRequest(InvoiceId id, boolean status) {
        this.invoiceId = id;
        this.status = status;
    }

    public static UpdateInvoiceStatusRequest of(InvoiceId value,boolean status){
        return new UpdateInvoiceStatusRequest(value, status);
    }

    public InvoiceId getId() {
        return invoiceId;
    }

    public boolean getStatus() {
        return status;
    }
}
