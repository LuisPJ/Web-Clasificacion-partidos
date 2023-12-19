package com.championship.championshipservices.controller;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.services.LoginServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private LoginServices championService;

    @ApiOperation("Login del administrador")
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Administrator admin) {
        return championService.loginUser(admin);
    }
}
