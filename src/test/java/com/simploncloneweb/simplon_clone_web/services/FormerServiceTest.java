package com.simploncloneweb.simplon_clone_web.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormerServiceTest {

    @Test
    void add() {
        FormerService formerService = new FormerService();
        System.out.println(formerService.add("Test", "Test", "elayachi@gmail.com", "pass"));

    }

    @Test
    void edit() {
        FormerService formerService = new FormerService();
        System.out.println(formerService.edit("Test", "Test", "elayachi@gmail.com", "pass",4));
    }
}