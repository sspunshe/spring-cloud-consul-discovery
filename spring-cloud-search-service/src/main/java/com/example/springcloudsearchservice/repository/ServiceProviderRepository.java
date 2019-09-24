package com.example.springcloudsearchservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.springcloudsearchservice.model.ServiceProviderInfo;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;


@Repository
@ViewIndexed(designDoc = "serviceProviderInfo")
public interface ServiceProviderRepository extends ReactiveCouchbaseRepository<ServiceProviderInfo, UUID> {

}
