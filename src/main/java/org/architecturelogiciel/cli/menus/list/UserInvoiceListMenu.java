package org.architecturelogiciel.cli.menus.list;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.*;
import org.architecturelogiciel.cli.menus.forms.CreateInvoiceForm;
import org.architecturelogiciel.core.models.Invoice;
import org.architecturelogiciel.core.models.User;

public class UserInvoiceListMenu extends Menu {
    public UserInvoiceListMenu(CLILauncher launcher, User user) {
        super(launcher, "List des factures pour " + user.getUsername());

        addAction(new Action("Choisir une facture") {
            @Override
            public void execute() {
                Invoice invoice = (Invoice) new InvoiceListSelectionMenu(launcher, user).startList();
                if (invoice != null){
                    launcher.setActiveMenu(new InvoiceInformationMenu(launcher, user, invoice));
                }else{
                    launcher.setActiveMenu(new UserMenu(launcher, user));
                }
            }
        });

        if (launcher.getClient().getUser().isTradesman()){
            addAction(new Action("Créer une nouvelle facture") {
                @Override
                public void execute() {
                    launcher.getClient().getInvoiceService().createInvoice(new CreateInvoiceForm().askEntries(user));
                    launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
                }
            });
        }
        addAction(new Action("Retour au menu précédent") {

            @Override
            public void execute() {
                if (launcher.getClient().getUser().isContractor()){
                    launcher.setActiveMenu(new InvoiceMenu(launcher, user));
                }else{
                    launcher.setActiveMenu(new UserMenu(launcher, user));
                }
            }
        });
    }
}
