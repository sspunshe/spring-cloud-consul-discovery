package com.example.springcloudsearchservice.router;

import com.example.springcloudsearchservice.handler.SearchHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SearchRoutes {
	
	@Bean
	public RouterFunction<ServerResponse> routes(SearchHandler searchHandler){
		return RouterFunctions.route()
				.GET("/serviceprovider/getproviders", searchHandler::getServiceProviders)
				.GET("/serviceprovider/getrequesttoprovider/{id}", searchHandler::getUserRequests)
				.build();
	}
	
}
