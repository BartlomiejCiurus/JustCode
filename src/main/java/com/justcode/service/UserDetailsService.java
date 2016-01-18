package com.justcode.service;

import com.justcode.model.User;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found!");
        }

        List<GrantedAuthority> grantedAuthorities = Collections.<GrantedAuthority>singletonList(
            new SimpleGrantedAuthority(user.getUserRoles().get(0).getRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
            true, true, true, grantedAuthorities);
    }
}
