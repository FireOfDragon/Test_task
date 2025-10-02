package com.example.test_task.service;

import com.example.test_task.dto.GeeseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestsService {

    private final String apiUrl;

    public RequestsService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public GeeseResponse fetchGeese() {
        return null;
    }
}
