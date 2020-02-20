package com.example.cp41.cp4icapstone;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.example";

    @Bean
    public Docket customerServicesV1Api() {

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any()).build().pathMapping("/").apiInfo(getApiInfo());
    }


    private static ApiInfo getApiInfo() {
        final ApiInfo apiInfo = new ApiInfo("Api Documentation for ICPI Capstone.", null, "0.0.1",
                null, null, null, null);
        return apiInfo;
    }

}
