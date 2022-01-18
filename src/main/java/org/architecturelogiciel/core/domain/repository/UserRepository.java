package org.architecturelogiciel.core.domain.repository;

import org.architecturelogiciel.core.kernel.exception.NoSuchUserException;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserType;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.application.requests.user.UpdateUserRequest;

import java.util.List;

public interface UserRepository {
        User findByUsername(String username) throws NoSuchUserException;
        User findById(UserId userId) throws NoSuchUserException;
        List<User> findAllUser();
        User createUser(SubscribeRequest subscribeRequest, UserType userType);
        void add(User user);
        void delete(User user);
        User update(UpdateUserRequest updateUserRequest);
        UserId nextId();
}
