package org.architecturelogiciel.cli.menus.forms;

import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;

public class CreateInvoiceForm extends Form{

    public CreateInvoiceForm() {
        super();
    }

    public CreateInvoiceRequest askEntries(User user){
        CreateInvoiceRequest request = CreateInvoiceRequest.of();
        request.setName(this.stringField("Entrez le nom de la facture:"));
        request.setPrice(this.numberField("Entrer un prix pour la facture", 0, 9999999));
        request.setUser(user);
        request.setStatus(false);
        return request;
    }
}
