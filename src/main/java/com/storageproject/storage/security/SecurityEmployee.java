package com.storageproject.storage.security;

import com.storageproject.storage.models.Employee;
import com.storageproject.storage.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityEmployee implements UserDetails {
    private final String username;
    private final String password;
    private final Role role;
    private final List<SimpleGrantedAuthority> authorities;
    public SecurityEmployee(String username, String password, Role role, List<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails fromUser(Employee employee) {
        return new org.springframework.security.core.userdetails.User(
                employee.getLogin(), employee.getPassword(),
                true,true, true, true,
                employee.getRole().getAuthorities()
        );
    }
}
