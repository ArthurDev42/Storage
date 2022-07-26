package com.storageproject.storage.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USE_STORAGE)),
    ADMIN(Set.of(Permission.USE_STORAGE, Permission.REGISTER_EMPLOYEE, Permission.REGISTER_PROVIDER));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
