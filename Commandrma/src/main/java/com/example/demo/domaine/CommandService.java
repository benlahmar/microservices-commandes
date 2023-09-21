package com.example.demo.domaine;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Command;
import com.example.demo.entities.Lignecommand;
import com.example.demo.exceptions.NoSuchCommandException;
import com.example.demo.infrastructure.ICommand;
import com.example.demo.infrastructure.ILigneCommand;

@Service
public class CommandService implements IService{

	@Autowired
	ICommand crepo;
	@Autowired
	ILigneCommand lgrepo;
	
	@Override
	public Command addcmd(Command c) {
		// TODO Auto-generated method stub
		return crepo.save(c);
	}
	@Override
	public Lignecommand addlgcmd(Lignecommand c, long idc) {
		
		Optional<Command> ct = crepo.findById(idc);
		if(ct.isPresent())
		{
			c.setCommand(ct.get());
				return lgrepo.save(c);
		}
		return null;
	}
	@Override
	public List<Command> allcmd() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}
	@Override
	public List<Command> allcmd(long idclient) {
		// TODO Auto-generated method stub
		return crepo.findByIdclient(idclient);
	}
	@Override
	public List<Command> allcmdperiode(LocalDate dd, LocalDate df) {
		// TODO Auto-generated method stub
		return crepo.findByDateBetween(dd, df);
	}
	@Override
	public List<Command> allcmdclientperiode(long idclient, LocalDate dd, LocalDate df) {
		// TODO Auto-generated method stub
		return crepo.findByIdclientAndDateBetween(idclient, dd, df);
	}
	@Override
	public List<Command> allcmdht() {
		Map<Long, Double> ht=new HashMap();
		   List<Command> res = crepo.findAll();
		   for (Command c : res) {
			List<Lignecommand> lg = c.getLignes();
			double htt=0;
			for (Lignecommand l : lg) {
				htt+=l.getPrice()*l.getQte();
			}
			ht.put(c.getId(), htt);
		}
		   
//		List<List<Double>> r = res.stream().map(
//				x->x.getLignes()
//					.stream()
//						.map(l->l.getPrice()*l.getQte())
//							.collect(Collectors.toList())).collect(Collectors.toList());
//		
		
		  
		  return null;
	}
	@Override
	public Command findcmd(long idc) {
		return crepo.findById(idc)
				.orElseThrow(()-> new NoSuchCommandException("commande not exsiste"));
		
	}

}
