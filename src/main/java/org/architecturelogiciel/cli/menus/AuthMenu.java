package org.architecturelogiciel.cli.menus;

import org.architecturelogiciel.cli.CLILauncher;
import org.architecturelogiciel.cli.menus.forms.AuthForm;
import org.architecturelogiciel.cli.menus.forms.SubscribeForm;

public class AuthMenu extends Menu{
    public AuthMenu(CLILauncher launcher) {
        super(launcher, "Authentication Menu");

        addAction(new Action("Authentification") {
            @Override
            public void execute() {
                try {
                    launcher.getClient().connect(new AuthForm().askEntries());
                    launcher.setActiveMenu(new MainMenu(launcher));
                }catch (Error error ){
                    launcher.setActiveMenu(new AuthMenu(launcher));
                }
            }
        });

        addAction(new Action("S'inscrire"){
            @Override
            public void execute() {
                try {
                    launcher.getClient().subscribe(new SubscribeForm().askEntries());
                    launcher.setActiveMenu(new MainMenu(launcher));
                }catch (Error error){
                    launcher.setActiveMenu(new AuthMenu(launcher));
                }
            }
        });
    }
}
