package com.celestii.springboot.springbootreact.controller;

import com.celestii.springboot.springbootreact.dto.SampleDTO;
import com.celestii.springboot.springbootreact.dto.SampleDTOList;
import com.celestii.springboot.springbootreact.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("")
    public void basic() {
        log.info("basic...................");
    }

    @GetMapping("/ex01")
    public void ex01(SampleDTO dto) {
        log.info(dto.toString());
    }

    @GetMapping("/ex02")
    public void ex02(@RequestParam String name, @RequestParam int age) {
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex02List")
    public void ex02List(@RequestParam("ids") List<String> ids) {
        log.info("ids: " + ids);
    }

    @GetMapping("/ex02Array")
    public void ex02Array(@RequestParam("ids") String[] ids) {
        log.info("ids: " + Arrays.toString(ids));
    }

    @GetMapping("/ex02Bean")
    public void ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
    }

    @GetMapping("/ex03")
    public void ex03(TodoDTO todo) {
        log.info("todo: " + todo);
    }

    @GetMapping("/ex04")
    public void ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05............");
    }

    @GetMapping("/ex06")
    public SampleDTO ex06() {
        log.info("/ex06............");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07..........");

        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);
    }
}
