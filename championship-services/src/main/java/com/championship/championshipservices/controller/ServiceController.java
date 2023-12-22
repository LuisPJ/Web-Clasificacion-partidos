package com.championship.championshipservices.controller;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.services.LoginServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ServiceController {

    @Autowired
    private LoginServices championService;

    @ApiOperation("Login del administrador")
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(
        @RequestParam String email,
        @RequestParam String password
    ) {
        Administrator admin = new Administrator();
        admin.setEmail(email);
        admin.setPassword(password);
        return championService.loginUser(admin);
    }
}
