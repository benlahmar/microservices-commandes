package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Testredfresh {

	@Value("${author.abc}")
	 String p;
	
	@GetMapping("commands/param")
	public String getparam()
	{
		return p;
	}
	
	
}
