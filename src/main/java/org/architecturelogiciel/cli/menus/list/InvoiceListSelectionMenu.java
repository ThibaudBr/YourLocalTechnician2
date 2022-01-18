package org.architecturelogiciel.cli.menus.list;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.user.User;

import java.util.List;

public class InvoiceListSelectionMenu extends ListSelectionMenu {
    private final User user;

    public InvoiceListSelectionMenu(CLILauncher launcher, User user) {
        super(launcher, "Selectionner une facture de " + user.getUsername());
        this.user = user;
    }

    @Override
    protected void loadEntityList() {
        List<Invoice> listInvoice = launcher.getClient().getInvoiceService().getInvoicesUser(user);
        for (Invoice invoice: listInvoice){
            addAction(new ListAction(invoice.getName()) {
                @Override
                public Object getEntity() {
                    return invoice;
                }
            });
        }
    }
}
