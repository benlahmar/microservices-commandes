package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domaine.IService;
import com.example.demo.entities.Client;
import com.example.demo.entities.Command;

@RestController
public class ComandApi {

	@Autowired
	IService service;
	@Autowired
	CustomerRemoteApi customerapi;
	
	@PostMapping("commands")
	public ResponseEntity<Command> addcmd(@RequestBody Command c)
	{
		Client cl = customerapi.getclient(c.getIdclient());
		if(cl!=null)
		{
			c=service.addcmd(c);
			c.setClient(cl);
			return new ResponseEntity<Command>(c,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<Command>(HttpStatus.NO_CONTENT);
		
		
	}
	@GetMapping("commands/{id}")
	public Command findcmd(@PathVariable long id)
	{
		Command c = service.findcmd(id);
		Client cl = customerapi.getclient(c.getIdclient());
		c.setClient(cl);
		return c;
	}
}
