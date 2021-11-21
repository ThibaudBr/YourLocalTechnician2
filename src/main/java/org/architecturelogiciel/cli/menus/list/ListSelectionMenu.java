package org.architecturelogiciel.cli.menus.list;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.Action;
import org.architecturelogiciel.cli.menus.Menu;

public abstract class ListSelectionMenu extends Menu {

    public ListSelectionMenu(CLILauncher launcher, String menuName) {
        super(launcher, menuName);
    }

    @Override
    public void addAction(Action action) {
        actions.add(action);
    }

    public void initActions() {
        loadEntityList();
        addAction(new ListAction("Retour au menu principal") {
            @Override
            public Object getEntity() {
                return null;
            }
        });
    }

    public Object startList() {
        initActions();
        if (actions.isEmpty()) {
            System.out.println("Il n'y a pour le moment aucun élément à sélectionner");
            return null;
        }
        return ((ListAction) actions.get(getChoice())).getEntity();
    }

    protected abstract void loadEntityList();
}
