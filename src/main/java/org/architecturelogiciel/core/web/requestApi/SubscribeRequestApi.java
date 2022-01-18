package org.architecturelogiciel.core.web.requestApi;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubscribeRequestApi {

    @NotNull
    @NotBlank
    public String username;

    @NotNull
    @NotBlank
    public String mail;

    @NotNull
    @NotBlank
    public String password;

    @NotNull
    @NotBlank
    public String userType;
}
