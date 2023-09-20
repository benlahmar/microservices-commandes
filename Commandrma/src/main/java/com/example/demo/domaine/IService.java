package com.example.demo.domaine;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.Command;
import com.example.demo.entities.Lignecommand;

public interface IService {

	public Command addcmd(Command c);
	public Lignecommand addlgcmd(Lignecommand c, long idc);
	public List<Command> allcmd();
	public List<Command> allcmd(long idclient);
	public List<Command> allcmdperiode(LocalDate dd, LocalDate df);
	public List<Command> allcmdclientperiode(long idclient,LocalDate dd, LocalDate df);
	public List<Command> allcmdht();
	
	public Command findcmd(long idc);
	
}
