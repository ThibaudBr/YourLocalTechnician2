package org.architecturelogiciel.core.repository;

import org.architecturelogiciel.core.exceptions.NoSuchUserException;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.models.UserType;
import org.architecturelogiciel.core.requests.SubscribeRequest;
import org.architecturelogiciel.core.requests.UpdateUserRequest;

import java.util.List;

public interface Users {
        User findByUsername(String username) throws NoSuchUserException;
        User findById(int userId) throws NoSuchUserException;
        List<User> findAllUser();
        User createUser(SubscribeRequest subscribeRequest, UserType userType);
        void add(User user);
        void delete(User user);
        User update(UpdateUserRequest updateUserRequest);

}
