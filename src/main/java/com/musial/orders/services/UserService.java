package com.musial.orders.services;

import com.musial.orders.entities.User;
import com.musial.orders.repositories.UserRepository;
import com.musial.orders.services.exceptions.DatabaseException;
import com.musial.orders.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User editUserById(Long id, User newUser) {
        try {
            User currentUser = userRepository.getReferenceById(id);
            User updatedUser = updateUser(newUser, currentUser);

            return userRepository.save(updatedUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private User updateUser(User newUser, User currentUser) {
        currentUser.setName(newUser.getName());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setPhone(newUser.getPhone());

        return currentUser;
    }
}
