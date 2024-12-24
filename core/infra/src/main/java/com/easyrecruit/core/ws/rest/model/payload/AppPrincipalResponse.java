package com.easyrecruit.core.ws.rest.model.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppPrincipalResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public AppPrincipalResponse(String token, Long id, String username, String email, List<String> roles) {
        this.accessToken = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}
