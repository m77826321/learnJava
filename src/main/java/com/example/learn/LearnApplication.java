package com.example.learn;

import com.example.learn.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import java.util.Collections;

@Import({
        SwaggerConfig.class,
})
@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {

        SpringApplication app =new SpringApplication(LearnApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","8080"));
        app.run(args);
    }

}
