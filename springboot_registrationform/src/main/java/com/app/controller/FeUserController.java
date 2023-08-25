package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.FeUser;
import com.app.service.FeUserService;

@RestController
@RequestMapping("/api/users")
public class FeUserController {
    private final FeUserService feUserService;

    @Autowired
    public FeUserController(FeUserService feUserService) {
        this.feUserService = feUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<FeUser> registerUser(@RequestBody FeUser user) {
        FeUser registeredUser = feUserService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FeUser> getUserById(@PathVariable Character userId) {
        FeUser user = feUserService.getUserById(userId);
       // System.err.println(user);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
        	//System.out.println("asdfgh");
            return ResponseEntity.notFound().build();
        }
    }

}
