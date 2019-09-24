package com.example.springcloudsearchservice.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.springcloudsearchservice.model.ServiceProviderInfo;
import com.example.springcloudsearchservice.service.SearchService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class SearchHandler {

	private final SearchService service;

	public SearchHandler(final SearchService service) {
		this.service = service;
	}

	public Mono<ServerResponse> getServiceProviders(ServerRequest request){
		return service.getServiceProvider().collectList()
		.flatMap(res -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(res)));
		
	}
	
	public Mono<ServerResponse> getUserRequests(ServerRequest request){
		Mono<ServiceProviderInfo> serviceProviderById = service.getServiceProviderById(UUID.fromString(request.pathVariable("id")));
		return serviceProviderById.flatMap(res -> service.getUserRequests().collectList()
				.flatMap(resp -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromObject(resp))))
				.switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromObject("Service Provider is not valid.")));
		
	}
}
