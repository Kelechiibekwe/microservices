package com.kelechitriescoding.customer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
            "com.kelechitriescoding.customer",
            "com.kelechitriescoding.amqp",
    }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.kelechitriescoding.clients"
)
public class CustomerApplication {
    public CustomerApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}


