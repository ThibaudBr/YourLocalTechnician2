package org.architecturelogiciel.cli;

import org.architecturelogiciel.cli.menus.AuthMenu;
import org.architecturelogiciel.cli.menus.Menu;
import org.architecturelogiciel.core.APIClient;

public class CLILauncher {
    private final APIClient client;
    private Menu activeMenu;

    public CLILauncher() {
        this.client = new APIClient();
        this.activeMenu = new AuthMenu(this);
    }

    public void start() {
        System.out.println("Starting CLI Menu");
        while (true) {
            activeMenu.start();
        }
    }

    public APIClient getClient() { return client;}

    public Menu getActiveMenu() { return activeMenu; }

    public void setActiveMenu(Menu activeMenu) { this.activeMenu = activeMenu;}


}
