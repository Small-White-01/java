package com.lezijie.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class AdminApplicationTests {

    @Test
    void contextLoads() {

        CharSequence charSequence="aaa";
        System.out.println(charSequence);//aaa
        System.out.println(charSequence.charAt(0));
        System.out.println(charSequence.toString());//aaa
        System.out.println(charSequence.subSequence(0,2));//aa
        System.out.println("".length());//0
        System.out.println(" ".length());//1
    }

}
