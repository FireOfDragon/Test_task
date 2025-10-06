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

    /**
     * Parses GeeseResponse entries
     *
     * @return List of Goose objects
     */
    public List<Goose> getAllGeese() {
        return null;
    }

    /**
     * Converts enum constant to camel case String
     *
     * @param type enum constant e.g."BIM_BOM"
     * @return String in camel case e.g. "BimBom"
     */
    private String normalizeType(String type) {
        return null;
    }
}
