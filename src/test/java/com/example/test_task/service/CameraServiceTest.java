package com.example.test_task.service;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CameraServiceTest {

    @Autowired
    private CameraService cameraService;

    @Autowired
    private MockWebServer mockWebServer;

    @BeforeEach
    void setupMockResponse() {
        String response = """
                {
                   "cameras": [
                     { "name": "CAM-1", "type": "PoweredOffCamera", "channels": 2 },
                     { "name": "Office", "type": "WorkingCamera", "channels": 3 },
                     { "name": "CAM-34", "type": "Error"}
                   ]
                 }
            """;
        mockWebServer.enqueue(
                new MockResponse()
                        .setBody(response)
                        .addHeader("Content-Type", "application/json")
        );
    }

    @Test
    void shouldParseValidCamerasCorrectly() {
        var cameras = cameraService.getAllCameras();

        assertThat(cameras).hasSize(2);
        assertThat(cameras.get(0).getName()).isEqualTo("Cam1");
        assertThat(cameras.get(1).getType()).isEqualTo("WorkingCamera");
    }
}

