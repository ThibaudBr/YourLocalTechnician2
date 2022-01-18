package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.list.UserListSelectionMenu;
import org.architecturelogiciel.core.domain.entities.user.User;

public class UsersMenu extends Menu {
    public UsersMenu(CLILauncher launcher) {
        super(launcher, "Gestion des utilisateurs:");

        addAction(new Action("Choisir un utilisateur") {
            @Override
            public void execute() {
                User user = (User) new UserListSelectionMenu(launcher).startList();
                launcher.setActiveMenu(new UserMenu(launcher, user));
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
