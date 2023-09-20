package com.example.demo.infrastructure;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Command;

public interface ICommand extends JpaRepository<Command, Long>{

	public List<Command> findByIdclient(long idc);
	public List<Command> findByDateBetween(LocalDate debut,LocalDate fin);
	public List<Command> findByIdclientAndDateBetween(long idc,LocalDate debut,LocalDate fin );
	@Query("from Command c where c.idclient=?1 and c.date>?2 and c.date<?3")
	public List<Command> findBycp(long idc,LocalDate debut,LocalDate fin);
	
	
	
}
