package com.celestii.springboot.springbootreact.domain.sample;

import org.junit.jupiter.api.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelTest {

    @Autowired
    private Hotel hotel;

    @Test
    public void testExists() {
        assertThat(hotel).isNotNull();
        assertThat(hotel.getChef()).isNotNull();
    }
}
