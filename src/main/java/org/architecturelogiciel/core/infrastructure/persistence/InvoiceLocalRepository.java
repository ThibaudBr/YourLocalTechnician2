package org.architecturelogiciel.core.infrastructure.persistence;

import org.architecturelogiciel.core.domain.repository.InvoiceRepository;
import org.architecturelogiciel.core.kernel.exception.NoSuchUserException;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceStatusRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class InvoiceLocalRepository implements InvoiceRepository {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final List<Invoice> invoiceList;

    public InvoiceLocalRepository() {
        this.invoiceList = new ArrayList<>();
    }

    @Override
    public Invoice findById(InvoiceId invoiceId) {
        AtomicReference<Invoice> invoice = new AtomicReference<>();
        invoiceList.forEach(invoice1 -> {
            if (invoice1.getId().equals(invoiceId)){
               invoice.set(invoice1);
            }
        });
        return invoice.get();
    }

    @Override
    public List<Invoice> findByUser(User user) throws NoSuchUserException {
        List<Invoice> userInvoiceList = new ArrayList<>();
        invoiceList.forEach(invoice -> {
            if (invoice.getUser().equals(user)){
                userInvoiceList.add(invoice);
            }
        });
        return userInvoiceList;
    }

    @Override
    public List<Invoice> findAll() {
        return this.invoiceList;
    }

    @Override
    public Invoice createInvoice(CreateInvoiceRequest invoiceRequest) {
        Invoice invoice = Invoice.of(InvoiceId.of(ID_GENERATOR.incrementAndGet()),invoiceRequest.getName(), invoiceRequest.getUser(), invoiceRequest.getStatus(), invoiceRequest.getPrice());
        this.add(invoice);
        return invoice;
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceList.remove(invoice);
    }

    @Override
    public Invoice updateInvoice(UpdateInvoiceRequest updateInvoiceRequest) {
        invoiceList.forEach(invoice -> {
            if (invoice.getId().getValue().equals(updateInvoiceRequest.getId().getValue())){
               invoice.setName(updateInvoiceRequest.getName());
               invoice.setPrice(updateInvoiceRequest.getPrice());
               invoice.setStatus(updateInvoiceRequest.getStatus());
               invoice.setUser(updateInvoiceRequest.getUser());
            }
        });
        return null;
    }

    @Override
    public void add(Invoice invoice) {
        invoiceList.add(invoice);
    }

    @Override
    public void updateStatus(UpdateInvoiceStatusRequest updateInvoiceStatusRequest) {
        invoiceList.forEach(invoice -> {
            if(invoice.getId().getValue().equals(updateInvoiceStatusRequest.getId().getValue())){
                invoice.setStatus(updateInvoiceStatusRequest.getStatus());
            }
        });
    }
}
