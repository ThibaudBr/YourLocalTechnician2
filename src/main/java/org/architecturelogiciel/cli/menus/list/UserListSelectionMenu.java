package org.architecturelogiciel.cli.menus.list;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.core.models.User;

import java.util.List;

public class UserListSelectionMenu extends ListSelectionMenu{
    public UserListSelectionMenu(CLILauncher launcher) {
        super(launcher, "Selectionner un Utilisateur");

    }

    @Override
    protected void loadEntityList() {
        List<User> listUser = launcher.getClient().getUsersService().getAllUser();
        for (User user: listUser){
            addAction(new ListAction(user.getUsername()) {
                @Override
                public Object getEntity() {
                    return user;
                }
            });
        }
    }
}
