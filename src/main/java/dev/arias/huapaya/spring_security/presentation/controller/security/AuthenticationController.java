package dev.arias.huapaya.spring_security.presentation.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.spring_security.presentation.dto.AuthenticationRequest;
import dev.arias.huapaya.spring_security.presentation.dto.AuthenticationResponse;
import dev.arias.huapaya.spring_security.service.security.AuthenticationService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.HashMap;

@AllArgsConstructor
@RestController
@RequestMapping(path = "auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PreAuthorize("permitAll()")
    @PostMapping(path = "authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = this.authenticationService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @PostMapping(path = "validate")
    public ResponseEntity<?> validate(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        Boolean validate = this.authenticationService.validateToken(request.get("jwt"));
        response.put("validate", validate ? "Valid" : "Invalid");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
