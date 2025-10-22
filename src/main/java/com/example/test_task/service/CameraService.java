package com.example.test_task.service;

import com.example.test_task.dto.CameraDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    private final RequestsService requestsService;

    public CameraService(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    /**
     * Parses CameraResponseDto entry
     *
     * @return List of CameraDto objects
     */
    public List<CameraDto> getAllCameras() {
        return null;
    }

    /**
     * Converts enum constant to camel case String
     *
     * @param type enum constant e.g."BimBom"
     * @return String in camel case e.g. "bim_bom"
     */
    private String normalizeType(String type) {
        return null;
    }
}
