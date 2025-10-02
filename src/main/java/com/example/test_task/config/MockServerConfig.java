package com.example.test_task.config;

import com.example.test_task.dto.GeeseTypes;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MockServerConfig {

    @Bean(destroyMethod = "shutdown")
    public MockWebServer start() throws IOException {
        MockWebServer server = new MockWebServer();
        server.start();
        return server;
    }

    @Bean
    public String apiUrl(MockWebServer server) throws JSONException {
        formResponse(server);
        return server.url("/geese/counter").toString();
    }

    private void formResponse(MockWebServer server) throws JSONException {
        JSONObject response = new JSONObject();
        JSONArray geeseArray = new JSONArray();

        JSONObject goose1 = new JSONObject();
        goose1.put("name", "Sanya");
        goose1.put("type", GeeseTypes.AFRO_AMERICAN_GOOSE);
        goose1.put("age", "2");

        JSONObject goose2 = new JSONObject();
        goose2.put("name", "Vanya");
        goose2.put("type", GeeseTypes.WHITE_GOOSE);
        goose2.put("age", "3");

        JSONObject goose3 = new JSONObject();
        goose3.put("name", "Danya");
        goose3.put("type", GeeseTypes.LEGENDARY);

        geeseArray.put(goose1);
        geeseArray.put(goose2);
        geeseArray.put(goose3);

        response.put("geese", geeseArray);

        server.enqueue(new MockResponse()
                .setBody(response.toString())
                .addHeader("Content-Type", "application/json"));
    }
}
