package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Lignecommand;

public interface ILigneCommand extends JpaRepository<Lignecommand, Long>{

}
