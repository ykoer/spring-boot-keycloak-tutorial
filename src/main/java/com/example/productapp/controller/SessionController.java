package com.example.productapp.controller;

import com.example.productapp.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by ykoer on 9/25/17.
 */
@Controller
@RequestMapping(value = "/session")
public class SessionController {

    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<User> getUsername(Principal principal) {
        if (principal!=null) {
            return ResponseEntity.ok(new User(principal.getName()));
        } else {
            throw new RestClientException("Not authenticated");
        }
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }
}
