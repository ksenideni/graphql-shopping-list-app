package com.example.graphqlshoppinglistapp.service;

import com.example.graphqlshoppinglistapp.entity.User;
import com.example.graphqlshoppinglistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String userName) {
        User newUser = new User();
        newUser.setUserName(userName);
        return userRepository.save(newUser);
    }

    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
