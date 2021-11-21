package org.architecturelogiciel.core.repository;

import org.architecturelogiciel.core.exceptions.NoSuchUserException;
import org.architecturelogiciel.core.models.Invoice;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.requests.CreateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceStatusRequest;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements Invoices{

    private final List<Invoice> invoiceList;

    public InvoiceRepository() {
        this.invoiceList = new ArrayList<>();
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
        Invoice invoice = new Invoice(invoiceRequest.getName(), invoiceRequest.getUser(), invoiceRequest.getStatus(), invoiceRequest.getPrice());
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
            if (invoice.getId() == updateInvoiceRequest.getId()){
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
            if(invoice.getId() == updateInvoiceStatusRequest.getId()){
                invoice.setStatus(updateInvoiceStatusRequest.getStatus());
            }
        });
    }
}
