package com.example.test_task.service;

import com.example.test_task.dto.GeeseResponse;
import com.example.test_task.dto.Goose;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeeseService {

    private final RequestsService requestsService;

    public GeeseService(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    public List<Goose> getAllGeese() {
        List<Goose> response = new ArrayList<>();
        GeeseResponse geese;
        try {
            geese = requestsService.fetchGeese();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        geese.getGeese().forEach(g -> {
            if (g.getName() != null && g.getType() != null && g.getAge() != 0) {
                Goose goose = new Goose();
                goose.setName(g.getName());
                goose.setType(normalizeType(g.getType()));
                goose.setAge(g.getAge());

                response.add(goose);
            }
        });


        return response;
    }

    private String normalizeType(String type) {
        return type.toLowerCase().transform(s -> Arrays.stream(s.split("_"))
                .map(w -> Character.toUpperCase(w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining()));
    }
}
