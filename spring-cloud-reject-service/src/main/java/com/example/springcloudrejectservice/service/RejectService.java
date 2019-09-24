package com.example.springcloudrejectservice.service;

import com.example.springcloudrejectservice.model.ServiceProviderInfo;
import com.example.springcloudrejectservice.model.UserRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RejectService {
	
	Mono<ServiceProviderInfo> getServiceProviderById(UUID id);
	
	Mono<UserRequest> getUserRequestByID(UUID id);
	
	Mono<UserRequest> acceptRequest(UserRequest userRequest);
	
	Mono<ServiceProviderInfo> addServiceProvider(ServiceProviderInfo serviceProviderInfo);
}
