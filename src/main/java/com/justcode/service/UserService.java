package com.justcode.service;

import com.justcode.model.User;
import com.justcode.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserPoints(Long id, int points) {
        userRepository.updateUsersPoints(id, points);
    }

    public List<User> getRanking() {
        return userRepository.getRanking();
    }
}
