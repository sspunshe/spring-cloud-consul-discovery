package com.example.springcloudregisterservice.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.List;
import java.util.UUID;

@Data
@Document
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceProviderInfo {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private UUID id;

    @Field
    @JsonProperty("firstName")
    private String firstName;

    @Field
    @JsonProperty("lastName")
    private String lastName;

    @Field
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @Field
    @JsonProperty("service")
    private List<String> service;

    @Field
    @JsonProperty("experience")
    private String experience;

    @Field
    @JsonProperty("userName")
    private String userName;

    @Field
    @JsonProperty("password")
    private String password;

    @Field
    @JsonProperty("confirmPassword")
    private String confirmPassword;

    @Field
    @JsonProperty("status")
    private String status;

}
