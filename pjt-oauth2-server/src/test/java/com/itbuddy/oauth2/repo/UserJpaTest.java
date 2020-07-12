package com.itbuddy.oauth2.repo;

import java.util.Collections;

import com.itbuddy.oauth2.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
// 프로파일을 나누었을때 제일 필요한 부분
@ActiveProfiles("dev")
public class UserJpaTest {
    @Autowired
    private UserJpaRepo userJpaRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void insertNewUser() {
        userJpaRepo.save(User.builder()
                .uid("happydaddy@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .name("happydaddy")
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }
}