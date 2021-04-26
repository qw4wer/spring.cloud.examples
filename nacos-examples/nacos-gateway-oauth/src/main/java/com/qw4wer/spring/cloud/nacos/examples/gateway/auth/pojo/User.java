package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class User implements UserDetails {

    private Integer id;

    private String username;

    private String password;

    private Set<String> apiResourceUrlSet;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (apiResourceUrlSet == null){
            return null;
        }
        return apiResourceUrlSet.stream().map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList());
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
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}