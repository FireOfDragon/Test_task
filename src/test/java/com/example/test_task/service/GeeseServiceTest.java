package com.example.test_task.service;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class GeeseServiceTest {

    @Autowired
    private GeeseService geeseService;

    @Autowired
    private MockWebServer mockWebServer;

    @BeforeEach
    void setupMockResponse() {
        String response = """
            {
              "geese": [
                {"name":"Sanya","type":"AFRO_AMERICAN_GOOSE","age":2},
                {"name":"Vanya","type":"WHITE_GOOSE","age":3},
                {"name":"Danya","type":"LEGENDARY","age":0}
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
    void shouldParseValidGeeseCorrectly() {
        var geese = geeseService.getAllGeese();

        assertThat(geese).hasSize(2);
        assertThat(geese.get(0).getName()).isEqualTo("Sanya");
        assertThat(geese.get(1).getType()).isEqualTo("WhiteGoose");
    }
}

