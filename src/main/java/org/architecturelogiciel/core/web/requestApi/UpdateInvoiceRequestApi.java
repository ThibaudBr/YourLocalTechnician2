package org.architecturelogiciel.core.web.requestApi;

import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateInvoiceRequestApi {

    @NotNull
    @NotBlank
    public InvoiceId invoiceId;

    @NotNull
    @NotBlank
    public String name;

    @NotNull
    @NotBlank
    public User user;

    @NotNull
    @NotBlank
    public Boolean status;

    @NotNull
    @NotBlank
    public int price;
}
