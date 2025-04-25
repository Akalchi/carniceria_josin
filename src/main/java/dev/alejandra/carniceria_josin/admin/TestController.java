package dev.alejandra.carniceria_josin.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.alejandra.carniceria_josin.security.CustomUserDetailsService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/user/{username}")
    public UserDetails getUserByUsername(@PathVariable String username) {
        return customUserDetailsService.loadUserByUsername(username);
    }
}