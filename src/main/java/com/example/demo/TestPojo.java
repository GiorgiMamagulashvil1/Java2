package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class TestPojo {

    @Loggable
    public void test(){
        System.out.println("Test method");
        this.testUtil();
    }

    @Loggable
    public void testUtil(){
        System.out.println("TestUtil method");
    }

}
