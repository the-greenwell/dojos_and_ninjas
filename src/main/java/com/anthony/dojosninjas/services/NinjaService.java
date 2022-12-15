package com.anthony.dojosninjas.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.anthony.dojosninjas.models.Dojo;
import com.anthony.dojosninjas.models.Ninja;
import com.anthony.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	public List<Ninja> findByDojo(Dojo dojo) {
		return ninjaRepo.findByDojo(dojo);
	}
}
