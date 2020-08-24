package com.celestii.springboot.springbootreact.domain.sample;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Hotel {

    private Chef chef;

    public Hotel(Chef chef) {
        this.chef = chef;
    }
}
