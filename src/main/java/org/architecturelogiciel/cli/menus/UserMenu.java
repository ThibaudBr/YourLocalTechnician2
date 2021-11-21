package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.list.UserInvoiceListMenu;
import org.architecturelogiciel.core.models.User;

public class UserMenu extends Menu {
    public UserMenu(CLILauncher launcher, User user) {
        super(launcher, "Menu de l'utilisateur " + user.getUsername());
        System.out.println(user);

        addAction(new Action("Afficher les factures de l'utilisateur") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new UserInvoiceListMenu(launcher, user));
            }
        });

        addAction(new Action("Supprimer l'utilisateur") {
            @Override
            public void execute() {
                launcher.getClient().getUsersService().deleteUser(user);
                launcher.setActiveMenu(new UsersMenu(launcher));
            }
        });
        addAction(new Action("Retour à la liste des utilsateurs") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new UsersMenu(launcher));
            }
        });
    }
}
