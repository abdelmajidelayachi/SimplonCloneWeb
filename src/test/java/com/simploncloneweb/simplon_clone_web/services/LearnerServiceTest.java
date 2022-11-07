package com.simploncloneweb.simplon_clone_web.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnerServiceTest {

    @Test
    void getAll() {
        System.out.println(new LearnerService().getAll().get(0).getIdLearner());
    }
}