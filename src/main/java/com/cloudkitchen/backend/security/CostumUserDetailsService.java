package com.cloudkitchen.backend.security;

import com.cloudkitchen.backend.model.Users;
import com.cloudkitchen.backend.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CostumUserDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    public CostumUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserNameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("user not found with Username or Email"+ userNameOrEmail));
        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role)-> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
        return new User(user.getEmail(),user.getPassword(),authorities);
    }
}
