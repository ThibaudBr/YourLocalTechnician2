package org.architecturelogiciel.cli.menus.forms;

import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.requests.CreateInvoiceRequest;

public class CreateInvoiceForm extends Form{

    public CreateInvoiceForm() {
        super();
    }

    public CreateInvoiceRequest askEntries(User user){
        CreateInvoiceRequest request = new CreateInvoiceRequest();
        request.setName(this.stringField("Entrez le nom de la facture:"));
        request.setPrice(this.numberField("Entrer un prix pour la facture", 0, 9999999));
        request.setUser(user);
        request.setStatus(false);
        return request;
    }
}
