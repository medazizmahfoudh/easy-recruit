package com.easyrecruit.core.ws.rest.web.ws;


import com.easyrecruit.core.service.impl.service.AuthService;
import com.easyrecruit.core.ws.rest.model.payload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core")
public class CoreWS {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/version",method = {RequestMethod.GET,RequestMethod.POST})
    private VersionResponse version() {
        return new VersionResponse();
    }


    @PostMapping("/login")
    public AppPrincipalResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        authService.signup(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
