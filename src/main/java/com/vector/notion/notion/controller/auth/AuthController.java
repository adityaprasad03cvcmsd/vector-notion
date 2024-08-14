package com.vector.notion.notion.controller.auth;

import com.vector.notion.notion.dto.user.LoginRequest;
import com.vector.notion.notion.dto.user.SignupRequest;
import com.vector.notion.notion.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;

@RestController
@RequestMapping("/auth/v1")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        try {
            String userId = authService.signup(req);

            HashMap<String, String> res = new HashMap<>();
            res.put("userId", userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            String userId = authService.login(req);
            HashMap<String, String> res = new HashMap<>();
            res.put("userId", userId);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
