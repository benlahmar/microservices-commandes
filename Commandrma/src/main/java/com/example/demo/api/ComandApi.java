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
import com.example.demo.entities.CommandDto;
import com.example.demo.entities.Lignecommand;
import com.example.demo.entities.Produit;
import com.example.demo.mapper.CommandMapper;

@RestController
public class ComandApi {

	@Autowired
	IService service;
	@Autowired
	CustomerRemoteApi customerapi;
	@Autowired
	CatalogueApi catelogueapi;
	
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
		c.getLignes().forEach(l->{
			l.setProduit(catelogueapi.getprd(l.getIdproduit()));
		});
		return c;
	}
	
	@PostMapping("lignecommands/{idcmd}")
	public Command addlignecommand(@RequestBody Lignecommand lcmd,@PathVariable long idcmd)
	{
		
		Lignecommand lg = service.addlgcmd(lcmd, idcmd);
		Command c = service.findcmd(idcmd);
		c.getLignes().forEach(l->{
			Produit p = catelogueapi.getprd(l.getIdproduit());
			l.setProduit(p);
		});
		
		return c;
	}
	
	@GetMapping("commands/{id}/facture")
	public CommandDto getFacture( long idcmd)
	{
		Command c = service.findcmd(idcmd);
		//converir en dto
		return CommandMapper.toDto(c);
	}
}
