package com.musial.orders.services;

import com.musial.orders.entities.User;
import com.musial.orders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User editUserById(Long id, User newUser) {
        User updatedUser = userRepository.getReferenceById(id);
        updatedUser.setName(newUser.getName());
        updatedUser.setEmail(newUser.getEmail());
        updatedUser.setPhone(newUser.getPhone());

        return userRepository.save(updatedUser);
    }
}
