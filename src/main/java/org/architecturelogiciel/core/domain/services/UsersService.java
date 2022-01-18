package org.architecturelogiciel.core.domain.services;

import org.architecturelogiciel.core.APIClient;
import org.architecturelogiciel.core.kernel.exception.NoSuchUserException;
import org.architecturelogiciel.core.kernel.exception.WrongUserUpdateException;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.infrastructure.persistence.UserLocalRepository;
import org.architecturelogiciel.core.application.requests.user.UpdateUserRequest;
import org.architecturelogiciel.core.kernel.validator.UpdateUserValidator;

import java.util.List;

public class UsersService extends Service<User> {
    private final UserLocalRepository userLocalRepository;

    public UsersService(APIClient apiClient) {
        super(User.class, apiClient);
        this.userLocalRepository = apiClient.getUserRepository();
    }

    public UserLocalRepository getUserRepository() {
        return userLocalRepository;
    }

    public List<User> getAllUser() {
        return userLocalRepository.findAllUser();
    }

    public User getById(UserId userId){
        try {
           return userLocalRepository.findById(userId);
        }catch (Error ignored){
            throw new NoSuchUserException();
        }
    }

    public void deleteUser(User user){
        try {
            userLocalRepository.delete(user);
        }catch (Error error){
            throw new NoSuchUserException();
        }
    }

    public User updateUser(UpdateUserRequest updateUserRequest){
        try {
            UpdateUserValidator.updateUserValidator(updateUserRequest);
            return userLocalRepository.update(updateUserRequest);
        }catch (Error ignored){
            throw new WrongUserUpdateException();
        }
    }
}
