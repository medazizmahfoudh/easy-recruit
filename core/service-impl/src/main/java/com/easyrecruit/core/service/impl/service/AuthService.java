package com.easyrecruit.core.service.impl.service;

import com.easyrecruit.core.dal.entity.AppUserEntity;
import com.easyrecruit.core.dal.entity.Token;
import com.easyrecruit.core.dal.entity.TokenType;
import com.easyrecruit.core.dal.repository.AppUserEntityRepository;
import com.easyrecruit.core.dal.repository.TokenRepository;
import com.easyrecruit.core.ws.rest.model.common.AppException;
import com.easyrecruit.core.ws.rest.model.entity.AppUser;
import com.easyrecruit.core.ws.rest.model.entity.AppUserRole;
import com.easyrecruit.core.ws.rest.model.payload.AppPrincipalResponse;
import com.easyrecruit.core.ws.rest.model.payload.LoginRequest;
import com.easyrecruit.core.ws.rest.model.payload.SignupRequest;
import net.thevpc.nuts.util.NOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private AppUserEntityRepository userRepository;
    @Autowired
    private JWTService jwtService;



    public AppPrincipalResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        AppUserEntity user = userRepository.findByUsernameOrEmail(request.getUsername(),request.getUsername())
                .orElseThrow(() -> new AppException("Authentication Exception","User is not found!"));

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);

        return new AppPrincipalResponse(jwtToken,
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole().getAuthorities().stream()
                        .map(SimpleGrantedAuthority::getAuthority)
                        .toList());
    }

    public void saveUserToken(AppUserEntity appUser, String jwtToken) {
        var token = Token.builder()
                .user(appUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public void signup(SignupRequest signUpRequest) {

        verifyUser(signUpRequest.getEmail());

        AppUser user = new AppUser()
                .setUsername(signUpRequest.getUsername())
                .setEmail(signUpRequest.getEmail())
                .setPassword(signUpRequest.getPassword())
                .setEnabled(true)
                .setRole(AppUserRole.RECRUITER);


        AppUserEntity appUserEntity = appUserService.addUser(user);
        var jwtToken = jwtService.generateToken(appUserEntity);
        saveUserToken(appUserEntity,jwtToken);


    }

    public void verifyUser(String email){
        NOptional<AppUser> user = appUserService.findUserByNameOrEmail(email, email);
        if (user.isPresent()){
            throw new AppException("Registration Exception", "Username or email already in use");
        }
    }


}
