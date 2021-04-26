package com.qw4wer.spring.cloud.oauth.services;

import com.qw4wer.spring.cloud.oauth.pojo.User;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by wxb on 2018/10/23 0023.
 * UserDetailsService的实现类，用于在程序中引入一个自定义的AuthenticationProvider，实现数据库访问模式的验证
 */
@Service
@Log
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MyUserBean userBean = mapper.selectByUsername(username);

//        if (userBean == null) {
//            throw new UsernameNotFoundException("数据库中无此用户！");
//        }
//        return userBean;
        log.info(username);
//        return new User(username, new BCryptPasswordEncoder().encode("pwd"), Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")}));
        HashSet<String> set = new HashSet<>();
        set.add("ROLE_USER");
        return new User(1, username, new BCryptPasswordEncoder().encode("pwd"), set);
    }
}