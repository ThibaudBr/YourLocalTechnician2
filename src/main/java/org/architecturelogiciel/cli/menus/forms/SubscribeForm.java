package org.architecturelogiciel.cli.menus.forms;

import org.architecturelogiciel.core.requests.SubscribeRequest;

public class SubscribeForm extends Form{
    public SubscribeForm() {
        super();
    }

    public SubscribeRequest askEntries() {
        SubscribeRequest request = new SubscribeRequest();
        request.setUserType(this.stringField("Entrez votre type d'ulisateur (TRADESMAN, CONTRACTOR):"));
        request.setUsername(this.stringField("Entrez votre nom d'utilisateur:"));
        request.setMail(this.stringField("Entrez votre mail:"));
        request.setPassword(this.passwordField("Entrez votre mot de passe:"));
        return request;
    }
}
