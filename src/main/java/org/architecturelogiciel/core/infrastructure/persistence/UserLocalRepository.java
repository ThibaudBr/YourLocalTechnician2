package org.architecturelogiciel.core.infrastructure.persistence;

import org.architecturelogiciel.core.domain.repository.UserRepository;
import org.architecturelogiciel.core.kernel.exception.NoSuchUserException;
import org.architecturelogiciel.core.domain.entities.user.User;
import org.architecturelogiciel.core.domain.entities.user.UserType;
import org.architecturelogiciel.core.domain.entities.user.UserId;
import org.architecturelogiciel.core.application.requests.user.SubscribeRequest;
import org.architecturelogiciel.core.application.requests.user.UpdateUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UserLocalRepository implements UserRepository {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private final List<User> userList;

    public UserLocalRepository() {
        userList = new ArrayList<>();
    }

    public User findByUsername(String username) throws NoSuchUserException {

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new NoSuchUserException();
    }

    @Override
    public User findById(UserId userId) throws NoSuchUserException {
        AtomicReference<User> user = new AtomicReference<>();
        userList.forEach(user1 -> {
            if (user1.getId().getValue() == userId.getValue()){
                user.set(user1);
            }
        });
        return user.get();
    }

    @Override
    public void add(User user) {
       userList.add(user);
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
    }

    @Override
    public User update(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public UserId nextId() {
        return UserId.of(ID_GENERATOR.incrementAndGet());
    }

    @Override
    public List<User> findAllUser() {
        return userList;
    }

    @Override
    public User createUser(SubscribeRequest subscribeRequest, UserType userType) {
        User user = User.of(nextId(), subscribeRequest.getUsername(), subscribeRequest.getMail(), subscribeRequest.getPassword(), userType);
        this.add(user);
        return user;
    }
}
