package com.example.springcloudregisterservice.service.impl;

import com.example.springcloudregisterservice.model.ServiceProviderInfo;
import com.example.springcloudregisterservice.repository.ServiceProviderRepository;
import com.example.springcloudregisterservice.service.RegisterSPService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RegisterSPServiceImpl implements RegisterSPService {

    private final ServiceProviderRepository serviceProviderRepository;

    public RegisterSPServiceImpl(final ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public Mono<ServiceProviderInfo> addServiceProvider(ServiceProviderInfo serviceProviderInfo) {
        return serviceProviderRepository.save(serviceProviderInfo);
    }

}
