package com.championship.championshipservices.services;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServices {
    @Autowired
    private LoginRepository loginRepository;
    public ResponseEntity<String> loginUser(Administrator admin) {
        try {
            Optional<Administrator> adminLogin = loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
            if(adminLogin.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador no esta registrado en la base de datos");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("Login exitoso");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }
}
