package org.architecturelogiciel.core.web.requestApi;

import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateInvoiceStatusRequestApi {

    @NotNull
    @NotBlank
    public InvoiceId invoiceId;

    @NotNull
    @NotBlank
    public boolean status;
}
