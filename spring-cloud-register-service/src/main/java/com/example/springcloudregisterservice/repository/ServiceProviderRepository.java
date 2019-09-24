package com.example.springcloudregisterservice.repository;

import com.example.springcloudregisterservice.model.ServiceProviderInfo;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@ViewIndexed(designDoc = "serviceProviderInfo")
public interface ServiceProviderRepository extends ReactiveCouchbaseRepository<ServiceProviderInfo, UUID> {
}
