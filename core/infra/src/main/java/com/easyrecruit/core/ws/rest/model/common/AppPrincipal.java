package com.easyrecruit.core.ws.rest.model.common;


import com.easyrecruit.core.ws.rest.model.entity.AppUser;

public interface AppPrincipal {
    AppUser getUser();
    
    Long getId();

    String getEmail();

    String getPassword();

    String getUsername();
}
