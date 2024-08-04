package com.testng;

import org.testng.annotations.Test;



public class FirstTestCase {

    @Test(priority=0)
    void setUp() {
        System.out.println("Set Up Test");
    }

    @Test(priority=1)
    void login(){
        System.out.println("This is a login test");
    }

    @Test(priority=2)
    void teardown(){
        System.out.println("This is a teardown test");
    }
    
    

    
}
