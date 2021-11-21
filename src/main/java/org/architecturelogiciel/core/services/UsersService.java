package org.architecturelogiciel.core.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.exceptions.NoSuchUserException;
import org.architecturelogiciel.core.exceptions.WrongUserUpdateException;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.repository.UserRepository;
import org.architecturelogiciel.core.requests.UpdateUserRequest;
import org.architecturelogiciel.core.validator.UpdateUserValidator;

import java.util.List;

public class UsersService extends Service<User> {
    private final UserRepository userRepository;

    public UsersService(APIClient apiClient) {
        super(User.class, apiClient);
        this.userRepository = apiClient.getUserRepository();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAllUser();
    }

    public User getById(int userId){
        try {
           return userRepository.findById(userId);
        }catch (Error ignored){
            throw new NoSuchUserException();
        }
    }

    public void deleteUser(User user){
        try {
            userRepository.delete(user);
        }catch (Error error){
            throw new NoSuchUserException();
        }
    }

    public User updateUser(UpdateUserRequest updateUserRequest){
        try {
            UpdateUserValidator.updateUserValidator(updateUserRequest);
            return userRepository.update(updateUserRequest);
        }catch (Error ignored){
            throw new WrongUserUpdateException();
        }
    }
}
