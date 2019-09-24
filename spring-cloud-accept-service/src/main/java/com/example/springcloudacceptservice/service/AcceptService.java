package com.example.springcloudacceptservice.service;

import com.example.springcloudacceptservice.model.ServiceProviderInfo;
import com.example.springcloudacceptservice.model.UserRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AcceptService {
	
	Mono<UserRequest> userRequestToProvider(UserRequest userRequest);
	
	Mono<ServiceProviderInfo> getServiceProviderById(UUID id);
	
	Mono<UserRequest> getUserRequestByID(UUID id);
	
	Mono<UserRequest> acceptRequest(UserRequest userRequest);
	
	Mono<ServiceProviderInfo> addServiceProvider(ServiceProviderInfo serviceProviderInfo);
}
