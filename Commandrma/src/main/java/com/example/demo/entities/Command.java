package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Command {

	@Id @GeneratedValue
	long id;
	@CreatedDate
	LocalDate date=LocalDate.now();
	
	@OneToMany(fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL, 
			mappedBy = "command")
	List<Lignecommand> lignes;
	
	CommandeState state=CommandeState.CREATED;
	
	long idclient;
	
	@Transient
	Client client;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Lignecommand> getLignes() {
		return lignes;
	}

	public void setLignes(List<Lignecommand> lignes) {
		this.lignes = lignes;
	}

	public long getIdclient() {
		return idclient;
	}

	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
