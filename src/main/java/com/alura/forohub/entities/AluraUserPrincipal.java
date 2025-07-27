package com.alura.forohub.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AluraUserPrincipal implements UserDetails
{
    private final AluraUser aluraUser;


    public AluraUserPrincipal(AluraUser aluraUser) {
        this.aluraUser = aluraUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Collections.singleton(new SimpleGrantedAuthority(aluraUser.getEmail()));
    }

    @Override
    public String getPassword() {
        return aluraUser.getPassword();
    }

    @Override
    public String getUsername()
    {

        return aluraUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
