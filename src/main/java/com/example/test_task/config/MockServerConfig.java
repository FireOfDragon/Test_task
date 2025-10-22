package com.example.test_task.config;

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
        return server.url("/cameras/counter").toString();
    }

    private void formResponse(MockWebServer server) throws JSONException {
        JSONObject response = new JSONObject();
        JSONArray geeseArray = new JSONArray();

        JSONObject camera1 = new JSONObject();
        camera1.put("name", "CAM-1");
        camera1.put("type", "PoweredOffCamera");
        camera1.put("channelCount", "2");

        JSONObject camera2 = new JSONObject();
        camera2.put("name", "Office");
        camera2.put("type", "WorkingCamera");
        camera2.put("channelCount", "3");

        JSONObject camera3 = new JSONObject();
        camera3.put("name", "CAM-34");
        camera3.put("type", "Error");

        geeseArray.put(camera1);
        geeseArray.put(camera2);
        geeseArray.put(camera3);

        response.put("cameras", geeseArray);

        server.enqueue(new MockResponse()
                .setBody(response.toString())
                .addHeader("Content-Type", "application/json"));
    }
}
