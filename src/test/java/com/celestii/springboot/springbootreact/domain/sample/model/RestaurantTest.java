package com.celestii.springboot.springbootreact.domain.sample.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertThat(restaurant).isNotNull();
        assertThat(restaurant.getChef()).isNotNull();
    }
}
