package com.zooclinic.zooclinic.service.impl;

import com.zooclinic.zooclinic.model.Owner;
import com.zooclinic.zooclinic.repo.OwnerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final OwnerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Owner> owner = Optional.ofNullable(repository.findByLogin(login));
        if(!owner.isPresent()){
            throw new RuntimeException(String.format("Пользователь %s не зарегистрирован", login));
        }
        UserDetails user = User.builder()
                .username(owner.get().getLogin())
                .password(owner.get().getPass())
                .roles(owner.get().getRole())
                .build();
        return user;
    }
}
