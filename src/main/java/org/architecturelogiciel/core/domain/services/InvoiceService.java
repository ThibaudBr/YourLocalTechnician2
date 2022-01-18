package org.architecturelogiciel.core.domain.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.kernel.exception.InvalidateInvoiceException;
import org.architecturelogiciel.core.kernel.exception.NoSuchInvoiceException;
import org.architecturelogiciel.core.kernel.exception.WrongInvoiceRequestException;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.infrastructure.persistence.InvoiceLocalRepository;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceStatusRequest;
import org.architecturelogiciel.core.kernel.validator.CreateInvoiceValidator;
import org.architecturelogiciel.core.kernel.validator.UpdateInvoiceStatusValidator;
import org.architecturelogiciel.core.kernel.validator.UpdateInvoiceValidator;

import java.util.List;

public class InvoiceService extends Service<Invoice> {
    private final InvoiceLocalRepository invoiceLocalRepository;

    public InvoiceService(APIClient client) {
        super(Invoice.class, client);
        this.invoiceLocalRepository = client.getInvoiceRepository();
    }

    public List<Invoice> getInvoicesUser(User user){
        return invoiceLocalRepository.findByUser(user);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceLocalRepository.findAll();
    }

    public Invoice createInvoice(CreateInvoiceRequest createInvoiceRequest){
        try {
            CreateInvoiceValidator.invoiceValidator(createInvoiceRequest);
            return invoiceLocalRepository.createInvoice(createInvoiceRequest);
        }catch (Error error){
            throw new WrongInvoiceRequestException();
        }
    }

    public void deleteInvoice(Invoice invoice){
        try {
            invoiceLocalRepository.deleteInvoice(invoice);
        }catch (Error ignored){
            throw new NoSuchInvoiceException();
        }
    }

    public Invoice updateInvoice(UpdateInvoiceRequest updateInvoiceRequest){
        try {
            UpdateInvoiceValidator.updateInvoiceValidator(updateInvoiceRequest);
            return invoiceLocalRepository.updateInvoice(updateInvoiceRequest);
        }catch (Error ignored){
            throw new InvalidateInvoiceException();
        }
    }

    public void updateStatus(UpdateInvoiceStatusRequest updateInvoiceStatusRequest){
        try {
            UpdateInvoiceStatusValidator.updateInvoiceStatusValidator(updateInvoiceStatusRequest);
            invoiceLocalRepository.updateStatus(updateInvoiceStatusRequest);
        }catch (Error ignored){
            throw new InvalidateInvoiceException();
        }
    }

    public Invoice findById(InvoiceId id) {
        try {
            return invoiceLocalRepository.findById(id);
        }catch (Error ignored){
            throw new NoSuchInvoiceException();
        }
    }
}
