package org.architecturelogiciel.core.web.controller;

import org.architecturelogiciel.core.application.query.invoice.RetrieveInvoice;
import org.architecturelogiciel.core.application.query.user.RetrieveUser;
import org.architecturelogiciel.core.application.requests.invoice.CreateInvoiceRequest;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.domain.entities.invoice.Invoice;
import org.architecturelogiciel.core.domain.entities.invoice.InvoiceId;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.kernel.query.QueryBus;
import org.architecturelogiciel.core.kernel.request.RequestBus;
import org.architecturelogiciel.core.web.requestApi.SubscribeRequestApi;
import org.architecturelogiciel.core.web.responseApi.InvoiceResponseApi;
import org.architecturelogiciel.core.web.responseApi.InvoicesResponseApi;
import org.architecturelogiciel.core.web.responseApi.UserResponseApi;
import org.architecturelogiciel.core.web.responseApi.UsersResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class InvoiceController {

    private final RequestBus requestBus;
    private final QueryBus queryBus;

    public InvoiceController(RequestBus requestBus, QueryBus queryBus) {
        this.requestBus = requestBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path= "/invoices", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InvoicesResponseApi> getAll() {
        final List<Invoice> invoiceList = queryBus.send(new RetrieveInvoice());
        InvoicesResponseApi invoicesResponseApi = new InvoicesResponseApi(invoiceList.stream().map(
                invoice -> InvoiceResponseApi.of(
                        invoice.getId(),
                        invoice.getName(),
                        invoice.getUser(),
                        invoice.getStatus(),
                        invoice.getPrice()
                )).collect(Collectors.toList()));
        return ResponseEntity.ok(invoicesResponseApi);
    }

    @PostMapping(path = "/invoice", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid CreateInvoiceRequest request){
        CreateInvoiceRequest createInvoiceRequest = CreateInvoiceRequest.of(request.getName(), request.getUser(), request.getStatus(), request.getPrice());
        InvoiceId invoiceId = requestBus.send(createInvoiceRequest);
        return ResponseEntity.created(URI.create("/invoice/" + invoiceId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
