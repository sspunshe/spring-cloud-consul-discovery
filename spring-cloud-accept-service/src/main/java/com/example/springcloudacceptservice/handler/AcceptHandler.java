package com.example.springcloudacceptservice.handler;

import java.util.UUID;

import com.example.springcloudacceptservice.model.ServiceProviderInfo;
import com.example.springcloudacceptservice.model.UserRequest;
import com.example.springcloudacceptservice.service.AcceptService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class AcceptHandler {
	
	private final AcceptService service;
	
	public AcceptHandler(final AcceptService service) {
		this.service = service;
	}
	
	public Mono<ServerResponse> userRequestToProvider(final ServerRequest request){
		return request.bodyToMono(UserRequest.class).flatMap(service::userRequestToProvider)
		.flatMap(service -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(service)));
		
	}
	
	public Mono<ServerResponse> acceptRequest(ServerRequest request){
		Mono<ServiceProviderInfo> serviceProviderById = service.getServiceProviderById(UUID.fromString(request.pathVariable("id")));
		return serviceProviderById.flatMap(ss -> request.bodyToMono(UserRequest.class))
		.flatMap(s -> service.getUserRequestByID(UUID.fromString(s.getUid())))
		.flatMap(rs -> {
			rs.setStatus("In Progress");
			rs.setUid(request.pathVariable("id"));
			return service.acceptRequest(rs);
		})
		.flatMap(res -> serviceProviderById)
		.flatMap(ress -> {
			ress.setStatus("In Progress");
			return service.addServiceProvider(ress);
		})
		.flatMap(resp -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(resp)))
		.switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject("Service Provider is not valid.")));
	}
	
}
