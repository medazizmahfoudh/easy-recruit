package com.easyrecruit.core.ws.rest.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    RECRUITER_READ("recruiter:read"),
    RECRUITER_CREATE("recruiter:create"),
    RECRUITER_UPDATE("recruiter:update"),
    RECRUITER_DELETE("recruiter:delete"),

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete");

    private final String permission;

}
