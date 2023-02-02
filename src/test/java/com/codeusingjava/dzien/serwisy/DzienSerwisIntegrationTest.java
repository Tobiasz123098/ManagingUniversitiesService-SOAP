package com.codeusingjava.dzien.serwisy;

import com.codeusingjava.SpringBootHelloWorldApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DzienSerwisIntegrationTest {

    @Autowired
    private DzienSerwis dzienSerwis;

    @Test
    public void test(){
        System.out.println("sdgsdfg");
    }
}