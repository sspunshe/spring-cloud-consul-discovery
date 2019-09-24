package com.example.springcloudacceptservice.service.impl;

import java.util.UUID;

import com.example.springcloudacceptservice.model.ServiceProviderInfo;
import com.example.springcloudacceptservice.model.UserRequest;
import com.example.springcloudacceptservice.repository.ServiceProviderRepository;
import com.example.springcloudacceptservice.repository.UserRequestRepository;
import com.example.springcloudacceptservice.service.AcceptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class AcceptServiceImpl implements AcceptService {
	
private final ServiceProviderRepository serviceProviderRepository;
	
	private final UserRequestRepository userRequestRepository;
			
	public AcceptServiceImpl(final ServiceProviderRepository serviceProviderRepository,
			final UserRequestRepository userRequestRepository) {
		this.serviceProviderRepository = serviceProviderRepository;
		this.userRequestRepository = userRequestRepository;
	}

	@Override
	public Mono<UserRequest> userRequestToProvider(UserRequest userRequest) {
		userRequest.setStatus("open");
		return userRequestRepository.save(userRequest);
	}

	@Override
	public Mono<ServiceProviderInfo> getServiceProviderById(UUID id) {
		return serviceProviderRepository.findById(id);
	}

	@Override
	public Mono<UserRequest> getUserRequestByID(UUID id) {
		return userRequestRepository.findById(id);
	}

	@Override
	public Mono<UserRequest> acceptRequest(UserRequest userRequest) {
		return userRequestRepository.save(userRequest);
	}

	@Override
	public Mono<ServiceProviderInfo> addServiceProvider(ServiceProviderInfo serviceProviderInfo) {
		return serviceProviderRepository.save(serviceProviderInfo);
	}
	
}
