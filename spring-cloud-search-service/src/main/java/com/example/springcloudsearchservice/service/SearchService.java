package com.example.springcloudsearchservice.service;

import com.example.springcloudsearchservice.model.ServiceProviderInfo;
import com.example.springcloudsearchservice.model.UserRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SearchService {
	
	Flux<ServiceProviderInfo> getServiceProvider();
	
	Flux<UserRequest> getUserRequests();
	
	Mono<ServiceProviderInfo> getServiceProviderById(UUID id);

}
