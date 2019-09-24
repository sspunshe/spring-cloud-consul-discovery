package com.example.springcloudregisterservice.service;

import com.example.springcloudregisterservice.model.ServiceProviderInfo;
import reactor.core.publisher.Mono;

public interface RegisterSPService {

    Mono<ServiceProviderInfo> addServiceProvider(ServiceProviderInfo serviceProviderInfo);

}
