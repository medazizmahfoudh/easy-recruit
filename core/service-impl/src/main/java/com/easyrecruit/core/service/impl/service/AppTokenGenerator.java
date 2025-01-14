package com.easyrecruit.core.service.impl.service;

import org.springframework.security.core.Authentication;

public interface AppTokenGenerator {
    String generateToken(Authentication authentication);
}
