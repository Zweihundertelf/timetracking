package com.tracking.timetracking.service;

import com.tracking.timetracking.model.UserModel;
import com.tracking.timetracking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String name, String password, String repeatPassword, String email) {
        if(name != null && password != null) {
            if(userRepository.findFirstByName(name).isPresent()) {
                System.out.println("already exists");
                return null;
            }
            if(!password.equals(repeatPassword)) {
                System.out.println("password do not match");
                return null;
            }
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setPassword(password);
            userModel.setRepeatPassword(repeatPassword);
            userModel.setEmail(email);
            return userRepository.save(userModel);
        } else {
            return null;
        }
    }

    public UserModel authenticate(String name, String password) {
        return userRepository.findByNameAndPassword(name, password).orElse(null);
    }
}
