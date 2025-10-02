package com.example.test_task.service;

import com.example.test_task.dto.Goose;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeeseService {

    private final RequestsService requestsService;

    public GeeseService(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    public List<Goose> getAllGeese() {
        return null;
    }

    private String normalizeType(String type) {
        return null;
    }
}
