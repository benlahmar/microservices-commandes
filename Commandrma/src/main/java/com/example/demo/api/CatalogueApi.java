package com.example.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Produit;

@FeignClient(name = "catalogue-service")
public interface CatalogueApi {

	@GetMapping("/produits2/{id}")
	public Produit getprd(@PathVariable long id);
}
