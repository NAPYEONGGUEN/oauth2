package com.itbuddy.oauth2.service.security;

import lombok.RequiredArgsConstructor;

import com.itbuddy.oauth2.entity.User;
import com.itbuddy.oauth2.repo.UserJpaRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    private final UserJpaRepo userJpaRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userJpaRepo.findByUid(name).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));
        logger.debug("******************");
        logger.debug(user.toString());
        logger.debug("******************");
        detailsChecker.check(user);
        return user;
    }
}