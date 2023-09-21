package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CommandDto {

	long id;
	LocalDate date;
	String nomclient;
	String etat;
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	List<Lignecommand> lignes;
	double ht;
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
	public String getNomclient() {
		return nomclient;
	}
	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}
	public List<Lignecommand> getLignes() {
		return lignes;
	}
	public void setLignes(List<Lignecommand> lignes) {
		this.lignes = lignes;
	}
	public double getHt() {
		return ht;
	}
	public void setHt(double ht) {
		this.ht = ht;
	}
	
	
	
}
