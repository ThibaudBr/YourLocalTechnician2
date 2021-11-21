package org.architecturelogiciel.core.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.exceptions.WrongPasswordExeception;
import org.architecturelogiciel.core.exceptions.WrongUserTypeException;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.models.UserType;
import org.architecturelogiciel.core.repository.UserRepository;
import org.architecturelogiciel.core.requests.LoginRequest;
import org.architecturelogiciel.core.requests.SubscribeRequest;
import org.architecturelogiciel.core.validator.LoginValidator;
import org.architecturelogiciel.core.validator.SubscribeValidator;

import java.security.InvalidParameterException;

public class AuthService extends Service<User>{

    private final UserRepository userRepository;

    public AuthService(APIClient apiClient) {
        super(User.class, apiClient);
        this.userRepository = apiClient.getUserRepository();
    }

    public User login(LoginRequest loginRequest) throws WrongPasswordExeception, InvalidParameterException {
        try{
            LoginValidator.loginValidator(loginRequest);
            User user = userRepository.findByUsername(loginRequest.getUsername());
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
            return userRepository.createUser(subscribeRequest, userType);
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
