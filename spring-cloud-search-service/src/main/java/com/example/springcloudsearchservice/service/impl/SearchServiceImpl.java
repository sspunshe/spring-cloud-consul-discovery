package com.example.springcloudsearchservice.service.impl;

import java.util.UUID;

import com.example.springcloudsearchservice.model.ServiceProviderInfo;
import com.example.springcloudsearchservice.model.UserRequest;
import com.example.springcloudsearchservice.repository.ServiceProviderRepository;
import com.example.springcloudsearchservice.repository.UserRequestRepository;
import com.example.springcloudsearchservice.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
	
	private final ServiceProviderRepository serviceProviderRepository;
	
	private final UserRequestRepository userRequestRepository;
			
	public SearchServiceImpl(final ServiceProviderRepository serviceProviderRepository,
			final UserRequestRepository userRequestRepository) {
		this.serviceProviderRepository = serviceProviderRepository;
		this.userRequestRepository = userRequestRepository;
	}

	@Override
	public Flux<ServiceProviderInfo> getServiceProvider() {
		return serviceProviderRepository.findAll().filter( p->p.getStatus().equalsIgnoreCase("open"))
				 .map(s -> {
					  s.setConfirmPassword(null);
					  s.setEmail(null);
					  s.setPassword(null);
					  s.setPhone(null);
					  s.setUserName(null);
					  return s;
				 });
	}

	@Override
	public Flux<UserRequest> getUserRequests() {
		return userRequestRepository.findAll().filter(res -> res.getStatus().contains("open"));
	}

	@Override
	public Mono<ServiceProviderInfo> getServiceProviderById(UUID id) {
		return serviceProviderRepository.findById(id);
	}
	
}
