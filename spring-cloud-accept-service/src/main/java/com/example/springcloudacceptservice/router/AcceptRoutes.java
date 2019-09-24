package com.example.springcloudacceptservice.router;

import com.example.springcloudacceptservice.handler.AcceptHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AcceptRoutes {
	
	@Bean
	public RouterFunction<ServerResponse> routes(AcceptHandler acceptHandler){
		return RouterFunctions.route()
				.POST("/serviceprovider/requesttoprovider", acceptHandler::userRequestToProvider)
				.POST("/serviceprovider/acceptrequest/{id}", acceptHandler::acceptRequest)
				.build();
		
	}
	
}
