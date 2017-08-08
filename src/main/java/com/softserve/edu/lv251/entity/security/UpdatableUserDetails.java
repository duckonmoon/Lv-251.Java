package com.softserve.edu.lv251.entity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Kovalevskyy Vitaliy
 * inspired by (https://stackoverflow.com/questions/14010326/how-to-change-the-login-name-for-the-current-user-with-spring-security-3-1/14174404#14174404)
 */
public class UpdatableUserDetails extends User {

    private String modifiedUserName;

    public UpdatableUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.modifiedUserName = username;
    }

    public UpdatableUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.modifiedUserName = username;
    }

    @Override
    public boolean equals(final Object rhs) {
        if (rhs instanceof User) {
            return this.modifiedUserName.equals(((User) rhs).getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String getUsername() {
        return this.modifiedUserName;
    }

    public void setUsername(final String username) {
        this.modifiedUserName = username;
    }
}
