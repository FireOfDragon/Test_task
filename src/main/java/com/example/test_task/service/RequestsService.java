package com.example.test_task.service;

import com.example.test_task.dto.GeeseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestsService {

    /**
     * Complete API link
     */
    private final String apiUrl;

    public RequestsService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * Builds and sends API request
     *
     * @return GeeseResponse object suitable for further analyze
     */
    public GeeseResponse fetchGeese() {
        return null;
    }
}
