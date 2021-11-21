package org.architecturelogiciel.core.repository;

import org.architecturelogiciel.core.exceptions.NoSuchUserException;
import org.architecturelogiciel.core.models.Invoice;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.requests.CreateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceStatusRequest;

import java.util.List;

public interface Invoices {
    List<Invoice> findByUser(User user) throws NoSuchUserException;
    List<Invoice> findAll();
    Invoice createInvoice(CreateInvoiceRequest invoiceRequest);
    void deleteInvoice(Invoice invoice);
    Invoice updateInvoice(UpdateInvoiceRequest updateInvoiceRequest);
    void add(Invoice invoice);
    void updateStatus(UpdateInvoiceStatusRequest updateInvoiceStatusRequest );

}
