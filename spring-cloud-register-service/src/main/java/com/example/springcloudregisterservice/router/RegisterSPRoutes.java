package com.example.springcloudregisterservice.router;

import com.example.springcloudregisterservice.handler.RegisterSPHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RegisterSPRoutes {

    @Bean
    public RouterFunction<ServerResponse> routes(RegisterSPHandler registerSPHandler){
        return RouterFunctions.route()
                .POST("/serviceprovider/add", registerSPHandler::addServiceProvider)
                .build();
    }

}
