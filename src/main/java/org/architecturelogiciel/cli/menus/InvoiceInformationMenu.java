package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.list.UserInvoiceListMenu;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.application.requests.invoice.UpdateInvoiceStatusRequest;

public class InvoiceInformationMenu extends Menu {
    public InvoiceInformationMenu(CLILauncher launcher, User user, Invoice invoice) {
        super(launcher, "Facture " + invoice.getName() + " de " + user.getUsername());
        System.out.println(invoice);

        if (launcher.getClient().getUser().isContractor() && Boolean.FALSE.equals(!invoice.getStatus())){
            addAction(new Action("Payer la facture") {
                @Override
                public void execute() {
                    // La logique de payment sera appelé ici
                    launcher.getClient().getInvoiceService().updateStatus(UpdateInvoiceStatusRequest.of(invoice.getId(), true));
                    launcher.setActiveMenu(new InvoiceInformationMenu(launcher, user, invoice));
                }
            });
        }

        if (launcher.getClient().getUser().isTradesman()){

            addAction(new Action("Changer le status ") {
                @Override
                public void execute() {
                    launcher.getClient().getInvoiceService().updateStatus(UpdateInvoiceStatusRequest.of(invoice.getId(), !invoice.getStatus()));
                    launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
                }
            });

            addAction(new Action("Supprimer la facture") {
                @Override
                public void execute() {
                    launcher.getClient().getInvoiceService().deleteInvoice(invoice);
                    launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
                }
            });
        }

        addAction(new Action("Retour à la liste des Factures") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
            }
        });
    }


}

