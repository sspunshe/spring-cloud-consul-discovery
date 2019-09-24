package com.example.springcloudrejectservice.service.impl;

import java.util.UUID;

import com.example.springcloudrejectservice.model.ServiceProviderInfo;
import com.example.springcloudrejectservice.model.UserRequest;
import com.example.springcloudrejectservice.repository.ServiceProviderRepository;
import com.example.springcloudrejectservice.repository.UserRequestRepository;
import com.example.springcloudrejectservice.service.RejectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RejectServiceImpl implements RejectService {
	
	private final ServiceProviderRepository serviceProviderRepository;
	
	private final UserRequestRepository userRequestRepository;
			
	public RejectServiceImpl(final ServiceProviderRepository serviceProviderRepository,
			final UserRequestRepository userRequestRepository) {
		this.serviceProviderRepository = serviceProviderRepository;
		this.userRequestRepository = userRequestRepository;
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
