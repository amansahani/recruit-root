package com.recruitroot.app.book;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Recruit Root Task: Aman Sahani")
                        .version("1.0")
                        .description("Recruit Root Task: Aman Sahani"));
    }
}
