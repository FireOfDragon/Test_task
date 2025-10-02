package com.example.test_task.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeeseResponse {
    public List<Goose> geese;

    @Getter
    @Setter
    public static class Goose {
        private String name;
        private String type;
        private int age;
    }
}
