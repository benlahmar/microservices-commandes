package com.example.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Client;

@FeignClient( name="customer-service")
public interface CustomerRemoteApi {

	@GetMapping("clients/{id}")
	public Client getclient(@PathVariable(name = "id") long idclient);
	 
	 
	 
}
