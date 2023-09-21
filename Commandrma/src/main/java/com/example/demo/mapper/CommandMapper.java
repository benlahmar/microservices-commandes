package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Command;
import com.example.demo.entities.CommandDto;

public class CommandMapper {

	public static CommandDto toDto(Command c)
	{
		CommandDto cd=new CommandDto();
		cd.setId(c.getId());
		cd.setDate(c.getDate());
		cd.setLignes(c.getLignes());
		
		double ht=0;
		List<Double> r = c.getLignes().stream()
		.map(x->x.getPrice()*x.getQte())
		.collect(Collectors.toList());
		for (Double d : r) {
			ht+=d;
		}
		cd.setHt(ht);
		return cd;
	}
//	public static Command toEntity(CommandDto cdto)
//	{
//		
//	}
}
