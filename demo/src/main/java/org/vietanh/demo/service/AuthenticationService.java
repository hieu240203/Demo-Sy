package org.vietanh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.vietanh.demo.util.JwtUtil;
import org.vietanh.demo.model.Users;
import org.vietanh.demo.repository.UsersRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(String email, String password) {
        Users user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            String jwtToken = jwtUtil.generateToken(user.getUsername());

            user.setJwtToken(jwtToken);
            userRepository.save(user);

            return jwtToken;
        } else {
            return null;
        }
    }
}
