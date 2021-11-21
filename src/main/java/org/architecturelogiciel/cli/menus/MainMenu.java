package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;

public class MainMenu extends Menu {
    public MainMenu(CLILauncher launcher) {
        super(launcher, "Menu principale");

        if (launcher.getClient().getUser().isTradesman()){
            addAction(new Action("Gestion des utilisateurs") {
                @Override
                public void execute() {
                    launcher.setActiveMenu(new UsersMenu(launcher));
                }
            });
        }

        if (launcher.getClient().getUser().isContractor()){

            addAction(new Action("Gestion des factures") {
                @Override
                public void execute() {
                    launcher.setActiveMenu(new InvoiceMenu(launcher, launcher.getClient().getUser() ));
                }
            });
        }

        addAction(new Action("Se déconnecter") {
            @Override
            public void execute() {
                launcher.getClient().disconnect();
                launcher.setActiveMenu(new AuthMenu(launcher));
            }
        });
    }
}
