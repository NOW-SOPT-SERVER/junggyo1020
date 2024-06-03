package org.sopt.practice.external;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("NOW SOPT PRACTICE SWAGGER")
                .description("NOW SOPT 세미나 & 실습 API 구현")
                .version("v1");

        return new OpenAPI()
                .info(info);
    }
}
