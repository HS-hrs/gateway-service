package HS_hrs.gateway_service.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder
            .routes()
            .route("user-service", r -> r.path("/user/**")
                .uri("lb://USER-SERVICE"))
            .route("employee-service", r -> r.path("/employee/**")
                .uri("lb://EMPLOYEE-SERVICE"))
            .route("vacation-service", r -> r.path("/vacation/**")
                .uri("lb://VACATION-SERVICE"))
            .build();
    }
}
