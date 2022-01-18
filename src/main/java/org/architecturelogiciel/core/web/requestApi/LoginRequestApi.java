package org.architecturelogiciel.core.web.requestApi;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequestApi {

    @NotNull
    @NotBlank
    public String username;

    @NotNull
    @NotBlank
    public String password;

}
