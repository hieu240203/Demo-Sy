package org.vietanh.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import org.vietanh.demo.service.AuthenticationService;
import org.vietanh.demo.service.UserService;
import org.vietanh.demo.dto.respone.UsersRespone;
import org.vietanh.demo.dto.request.UsersRequest;


@RestController
@RequestMapping("/ui/v1/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/signup") // POST http://localhost:8080/ui/v1/auth/signup
    public ResponseEntity<String> signup(@RequestBody UsersRespone user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully!");
    }

    @PostMapping("/login") // POST http://localhost:8080/ui/v1/auth/login
    public ResponseEntity<String> login(@RequestBody UsersRequest user){
        String email = user.getEmail();
        String password = user.getPassword();

        String  jwtToken  = authenticationService.authenticate(email, password);

        if (jwtToken != null) {
            return ResponseEntity.ok(jwtToken); // 200
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
