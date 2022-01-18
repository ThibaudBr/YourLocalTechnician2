package org.architecturelogiciel.core.domain.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.kernel.exception.WrongPasswordExeception;
import org.architecturelogiciel.core.kernel.exception.WrongUserTypeException;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserType;
import org.architecturelogiciel.core.infrastructure.persistence.UserLocalRepository;
import org.architecturelogiciel.core.application.requests.user.LoginRequest;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.kernel.validator.LoginValidator;
import org.architecturelogiciel.core.kernel.validator.SubscribeValidator;

import java.security.InvalidParameterException;

public class AuthService extends Service<User>{

    private final UserLocalRepository userLocalRepository;

    public AuthService(APIClient apiClient) {
        super(User.class, apiClient);
        this.userLocalRepository = apiClient.getUserRepository();
    }

    public User login(LoginRequest loginRequest) throws WrongPasswordExeception, InvalidParameterException {
        try{
            LoginValidator.loginValidator(loginRequest);
            User user = userLocalRepository.findByUsername(loginRequest.getUsername());
            if (user.getPassword().equals(loginRequest.getPassword())){
                return user;
            }else {
                throw new WrongPasswordExeception();
            }
        }catch (Error ignored){
            throw new InvalidParameterException();
        }
    }

    public User subscribe(SubscribeRequest subscribeRequest) {
        try {
            SubscribeValidator.subscribeValidator(subscribeRequest);
            UserType userType = getUserType(subscribeRequest.getUserType());
            return userLocalRepository.createUser(subscribeRequest, userType);
        }catch (Error ignored){
            throw new InvalidParameterException();
        }
    }

    private UserType getUserType(String userType) {
        if (userType.equals("TRADESMAN")){
            return UserType.TRADESMAN;
        }else if(userType.equals("CONTRACTOR")){
            return UserType.CONTRACTOR;
        }else{
            throw new WrongUserTypeException();
        }
    }
}
