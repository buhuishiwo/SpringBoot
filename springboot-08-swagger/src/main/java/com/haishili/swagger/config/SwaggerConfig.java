package com.haishili.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haishili
 * @date 2025/5/7
 */
@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
            return new OpenAPI()
                .info(new Info()
                                .title("My API")
                                .version("v1")
                                .description("接口描述")
                                .contact(new Contact()
                                        .email("1234354@qq.com")
                                        .name("李华")
                                        .url("https://github.com")));
    }
}
