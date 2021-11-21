package org.architecturelogiciel.cli.menus.list;

import org.architecturelogiciel.cli.menus.Action;

public abstract class ListAction extends Action {
    public ListAction(String displayAction) {
        super(displayAction);
    }

    public abstract Object getEntity();

    @Override
    public void execute() {

    }
}
