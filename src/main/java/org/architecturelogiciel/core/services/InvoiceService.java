package org.architecturelogiciel.core.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.exceptions.InvalidateInvoiceException;
import org.architecturelogiciel.core.exceptions.NoSuchInvoiceException;
import org.architecturelogiciel.core.exceptions.WrongInvoiceRequestException;
import org.architecturelogiciel.core.models.Invoice;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.repository.InvoiceRepository;
import org.architecturelogiciel.core.requests.CreateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceRequest;
import org.architecturelogiciel.core.requests.UpdateInvoiceStatusRequest;
import org.architecturelogiciel.core.validator.CreateInvoiceValidator;
import org.architecturelogiciel.core.validator.UpdateInvoiceStatusValidator;
import org.architecturelogiciel.core.validator.UpdateInvoiceValidator;

import java.util.List;

public class InvoiceService extends Service<Invoice> {
    private final InvoiceRepository invoiceRepository = new InvoiceRepository();

    public InvoiceService(APIClient client) {
        super(Invoice.class, client);
    }

    public List<Invoice> getInvoicesUser(User user){
        return invoiceRepository.findByUser(user);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public Invoice createInvoice(CreateInvoiceRequest createInvoiceRequest){
        try {
            CreateInvoiceValidator.invoiceValidator(createInvoiceRequest);
            return invoiceRepository.createInvoice(createInvoiceRequest);
        }catch (Error error){
            throw new WrongInvoiceRequestException();
        }
    }

    public void deleteInvoice(Invoice invoice){
        try {
            invoiceRepository.deleteInvoice(invoice);
        }catch (Error ignored){
            throw new NoSuchInvoiceException();
        }
    }

    public Invoice updateInvoice(UpdateInvoiceRequest updateInvoiceRequest){
        try {
            UpdateInvoiceValidator.updateInvoiceValidator(updateInvoiceRequest);
            return invoiceRepository.updateInvoice(updateInvoiceRequest);
        }catch (Error ignored){
            throw new InvalidateInvoiceException();
        }
    }

    public void updateStatus(UpdateInvoiceStatusRequest updateInvoiceStatusRequest){
        try {
            UpdateInvoiceStatusValidator.updateInvoiceStatusValidator(updateInvoiceStatusRequest);
            invoiceRepository.updateStatus(updateInvoiceStatusRequest);
        }catch (Error ignored){
            throw new InvalidateInvoiceException();
        }
    }
}
