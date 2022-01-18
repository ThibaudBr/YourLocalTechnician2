package org.architecturelogiciel.core.web.controller;

import org.architecturelogiciel.core.application.query.user.RetrieveUser;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.kernel.query.QueryBus;
import org.architecturelogiciel.core.kernel.request.RequestBus;
import org.architecturelogiciel.core.web.requestApi.SubscribeRequestApi;
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
public class UserController {

    private final RequestBus requestBus;
    private final QueryBus queryBus;

    public UserController(RequestBus requestBus, QueryBus queryBus) {
        this.requestBus = requestBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path= "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponseApi> getAll() {
        final List<User> userList = queryBus.send(new RetrieveUser());
        UsersResponseApi usersResponseApi = new UsersResponseApi(userList.stream().map(
                user -> new UserResponseApi(
                        user.getId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getMail(),
                        user.getUserType()
                )).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseApi);
    }

    @PostMapping(path = "/user/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid SubscribeRequestApi request){
        SubscribeRequest subscribeRequest = SubscribeRequest.of(request.username, request.mail, request.password, request.userType);
        UserId userId = requestBus.send(subscribeRequest);
        return ResponseEntity.created(URI.create("/user/" + userId.getString())).build();
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
