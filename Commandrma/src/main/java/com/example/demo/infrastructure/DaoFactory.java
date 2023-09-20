package com.example.demo.infrastructure;

import org.springframework.beans.factory.annotation.Value;

public class DaoFactory {

	@Value("${type}")
	String type;

	public static IDao getDaoFactory(String type) {
		
		if(type.equals("jpa"))
		{
			return new DaoImplJpa();
		}
		else
			if(type.endsWith("xml"))
				return new DaoImplXml();
		
		
		return null;
	}
	
}
