package com.example.basicauth.service;

import com.example.basicauth.jwt.Util;
import com.example.basicauth.model.RefreshToken;
import com.example.basicauth.request.LoginRequest;
import com.example.basicauth.response.LoginResponse;
import com.example.basicauth.security.AppUser;
import com.example.basicauth.security.SecurityConfig;
import com.example.basicauth.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private Util util;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    RefreshTokenService refreshTokenService;

    public ResponseEntity<?> login(LoginRequest loginRequest) throws Exception {
        try {

            Authentication authentication =
                    securityConfig.authenticationManagerBean().authenticate(
                            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
                    );

            final UserDetails userDetails = userAuthenticationService
                    .loadUserByUsername(loginRequest.getUsername());

            AppUser appUser = (AppUser) authentication.getPrincipal();


            final String jwtToken = util.generateToken(userDetails);

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(appUser.getUser().getId());

            return ResponseEntity.ok(new LoginResponse(jwtToken, "Bearer", refreshToken.getToken(), appUser.getUsername(),
                    appUser.getUser().getId()));

        } catch (BadCredentialsException e) {

            throw new Exception("Usuário e senha incorretas", e);
        }
    }
}