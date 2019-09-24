package com.example.springcloudacceptservice.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private UUID id;
	
	@Field
	@JsonProperty("service")
	private String service;
	
	@Field
	@JsonProperty("name")
	private String name;
	
	@Field
	@JsonProperty("status")
	private String status;
	
	@Field
	@JsonProperty("uid")
	private String uid;

}
