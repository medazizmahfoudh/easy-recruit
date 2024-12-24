package com.easyrecruit.core.service.api;

import com.easyrecruit.core.ws.rest.model.payload.AppPrincipalResponse;
import com.easyrecruit.core.ws.rest.model.payload.LoginRequest;
import com.easyrecruit.core.ws.rest.model.payload.SignupRequest;
import com.easyrecruit.core.ws.rest.model.payload.VersionResponse;

public interface CoreModule {

    AppPrincipalResponse login(LoginRequest request);
    VersionResponse version();
    void signup(SignupRequest signUpRequest);
}
