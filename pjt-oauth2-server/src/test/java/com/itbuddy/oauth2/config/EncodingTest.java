package com.itbuddy.oauth2.config;

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
public class EncodingTest {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Test
    public void encodeTest() {
        System.out.printf("******************************");
        System.out.printf("testSecret : %s\n", passwordEncoder.encode("testSecret"));
        System.out.printf("******************************");
    }
    
}