package org.architecturelogiciel.core.application.query.invoice.handler;

import org.architecturelogiciel.core.application.query.invoice.RetrieveInvoice;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.repository.InvoiceRepository;
import org.architecturelogiciel.core.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveInvoiceHandler implements QueryHandler<RetrieveInvoice, List<Invoice>> {

    private final InvoiceRepository invoiceRepository;

    public RetrieveInvoiceHandler(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> handle(RetrieveInvoice query) {
        return invoiceRepository.findAll();
    }
}
