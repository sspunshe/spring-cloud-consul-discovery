package com.example.springcloudrejectservice.handler;

import java.util.UUID;

import com.example.springcloudrejectservice.model.ServiceProviderInfo;
import com.example.springcloudrejectservice.model.UserRequest;
import com.example.springcloudrejectservice.service.RejectService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class RejectHandler {
	
	private final RejectService service;
	
	public RejectHandler(final RejectService service) {
		this.service = service;
	}
	
	public Mono<ServerResponse> rejectRequest(ServerRequest request){
		Mono<ServiceProviderInfo> serviceProviderById = service.getServiceProviderById(UUID.fromString(request.pathVariable("id")));
		return serviceProviderById.flatMap(ss -> request.bodyToMono(UserRequest.class))
		.flatMap(s -> service.getUserRequestByID(UUID.fromString(s.getUid())))
		.flatMap(rs -> {
			rs.setStatus("Rejected");
			rs.setUid(request.pathVariable("id"));
			return service.acceptRequest(rs);
		})
		.flatMap(res -> serviceProviderById)
		.flatMap(ress -> {
			ress.setStatus("Open");
			return service.addServiceProvider(ress);
		})
		.flatMap(resp -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(resp)))
		.switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject("Service Provider is not valid.")));
	}
	
}
