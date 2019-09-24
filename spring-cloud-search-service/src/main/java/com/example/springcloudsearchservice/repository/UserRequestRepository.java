package com.example.springcloudsearchservice.repository;

import java.util.UUID;

import com.example.springcloudsearchservice.model.UserRequest;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;


@Repository
@ViewIndexed(designDoc = "userRequest")
public interface UserRequestRepository extends ReactiveCouchbaseRepository<UserRequest, UUID> {

}
