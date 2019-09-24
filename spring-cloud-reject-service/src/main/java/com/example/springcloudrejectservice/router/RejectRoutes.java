package com.example.springcloudrejectservice.router;

import com.example.springcloudrejectservice.handler.RejectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RejectRoutes {
	
	@Bean
	public RouterFunction<ServerResponse> routes(RejectHandler rejectHandler){
		return RouterFunctions.route()
				.POST("/serviceprovider/rejectrequest/{id}", rejectHandler::rejectRequest)
				.build();
		
	}
}
