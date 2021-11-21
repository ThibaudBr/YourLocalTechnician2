package org.architecturelogiciel.core.repository;

import org.architecturelogiciel.core.exceptions.NoSuchUserException;
import org.architecturelogiciel.core.models.User;
import org.architecturelogiciel.core.models.UserType;
import org.architecturelogiciel.core.requests.SubscribeRequest;
import org.architecturelogiciel.core.requests.UpdateUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UserRepository implements Users{
    private final List<User> userList;

    public UserRepository() {
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
    public User findById(int userId) throws NoSuchUserException {
        AtomicReference<User> user = new AtomicReference<>(new User());
        userList.forEach(user1 -> {
            if (user1.getId() == userId){
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
    public List<User> findAllUser() {
        return userList;
    }

    @Override
    public User createUser(SubscribeRequest subscribeRequest, UserType userType) {
        User user = new User(subscribeRequest.getUsername(), subscribeRequest.getMail(), subscribeRequest.getPassword(), userType);
        this.add(user);
        return user;
    }
}
