package org.architecturelogiciel.cli.menus.forms;

import org.architecturelogiciel.core.application.requests.user.LoginRequest;

public class AuthForm extends Form{

    public AuthForm(){ super();}

    public LoginRequest askEntries() {
        LoginRequest request = LoginRequest.of();
        request.setUsername(this.stringField("Entrez votre nom d'utilisateur:"));
        request.setPassword(this.passwordField("Entrez votre mot de passe:"));
        return request;
    }
}
