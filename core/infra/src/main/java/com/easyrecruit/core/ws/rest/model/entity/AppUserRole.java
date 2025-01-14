package com.easyrecruit.core.ws.rest.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Getter
public enum AppUserRole {

    RECRUITER(
            Set.of(
                Permission.RECRUITER_READ, Permission.RECRUITER_UPDATE, Permission.RECRUITER_CREATE, Permission.RECRUITER_DELETE
            )
    ),
    ADMIN(
            Set.of(
            Permission.ADMIN_CREATE, Permission.ADMIN_READ, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
