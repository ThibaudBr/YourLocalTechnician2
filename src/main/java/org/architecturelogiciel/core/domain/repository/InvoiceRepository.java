package org.architecturelogiciel.core.domain.repository;

import org.architecturelogiciel.core.kernel.exception.NoSuchUserException;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceStatusRequest;

import java.util.List;

public interface InvoiceRepository {
    Invoice findById(InvoiceId invoiceId);
    List<Invoice> findByUser(User user) throws NoSuchUserException;
    List<Invoice> findAll();
    Invoice createInvoice(CreateInvoiceRequest invoiceRequest);
    void deleteInvoice(Invoice invoice);
    Invoice updateInvoice(UpdateInvoiceRequest updateInvoiceRequest);
    void add(Invoice invoice);
    void updateStatus(UpdateInvoiceStatusRequest updateInvoiceStatusRequest );
}
