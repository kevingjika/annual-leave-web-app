package com.alwa.annualleavewebapp.services;

import com.alwa.annualleavewebapp.entities.User;
import com.alwa.annualleavewebapp.exceptions.NoUserFoundException;
import com.alwa.annualleavewebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user) throws NoUserFoundException {

        user.setUsername(user.getUsername());
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setAddress(user.getAddress());

        Optional<User> findIfUserExists1 = userRepository.findUserByEmail(user.getEmail());
        Optional<User> findIfUserExists2 = userRepository.findUserByPassword(user.getPassword());

        if (findIfUserExists1.isPresent() && findIfUserExists2.isPresent()) {
            throw new NoUserFoundException("User exists.");
        }

        return userRepository.save(user);

    }

    public User editUser(User user) throws NoUserFoundException {

        Optional<User> findIfUserExists = userRepository.findById(user.getId());
        findIfUserExists.get().setPassword(user.getPassword());

        if (!findIfUserExists.isPresent()) {
            throw new NoUserFoundException("User doesn't exists.");
        }

        return userRepository.save(findIfUserExists.get());

    }

    public void deleteUser(long id) throws NoUserFoundException {

        Optional<User> findIfUserExists = userRepository.findById(id);

        if(!findIfUserExists.isPresent()) {
            throw new NoUserFoundException(("User doesn't exists."));
        }

        userRepository.deleteById(id);

    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User login(User user) throws NoUserFoundException {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        Optional<User> findIfUserExists1 = userRepository.findUserByEmail(user.getEmail());
        Optional<User> findIfUserExists2 = userRepository.findUserByPassword(user.getPassword());

        if (!findIfUserExists1.isPresent() && !findIfUserExists2.isPresent()) {
            throw new NoUserFoundException("User doesn't exists.");
        }

        return userRepository.save(user);
    }
}
