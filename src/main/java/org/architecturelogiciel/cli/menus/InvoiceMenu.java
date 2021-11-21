package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.list.UserInvoiceListMenu;
import org.architecturelogiciel.core.models.Invoice;
import org.architecturelogiciel.core.models.User;

public class InvoiceMenu extends Menu {
    public InvoiceMenu(CLILauncher launcher, User user) {
        super(launcher, "Menu de gestion des factures:");

        addAction(new Action("Afficher vos factures ") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
            }
        });

        addAction(new Action("Retour au menu principal") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new MainMenu(launcher));
            }
        });
    }
}
