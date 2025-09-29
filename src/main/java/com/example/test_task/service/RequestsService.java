package com.example.test_task.service;

import com.example.test_task.config.MockServerConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class RequestsService {

    private final String apiUrl;

    public RequestsService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String fetchGeese() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Bean
    CommandLineRunner init(MockServerConfig mockServerConfig) {
        return args -> {
            System.out.println(fetchGeese());
        };
    }
}
