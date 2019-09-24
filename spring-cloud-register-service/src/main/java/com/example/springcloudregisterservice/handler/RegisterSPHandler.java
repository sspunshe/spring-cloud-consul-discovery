package com.example.springcloudregisterservice.handler;

import com.example.springcloudregisterservice.model.ServiceProviderInfo;
import com.example.springcloudregisterservice.service.RegisterSPService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class RegisterSPHandler {

    private final RegisterSPService service;

    public RegisterSPHandler(final RegisterSPService service) {
        this.service = service;
    }

    public Mono<ServerResponse> addServiceProvider(final ServerRequest request) {

        return request.bodyToMono(ServiceProviderInfo.class).flatMap(service::addServiceProvider)
                .flatMap(service -> ServerResponse.created(null).contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(service)));

    }

}
