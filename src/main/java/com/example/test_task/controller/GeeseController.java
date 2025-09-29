package com.example.test_task.controller;

import com.example.test_task.service.GeeseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farm/geese")
@AllArgsConstructor
public class GeeseController {

    private final GeeseService geeseService;

}
