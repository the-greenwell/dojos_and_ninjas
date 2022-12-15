package com.anthony.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony.dojosninjas.models.Dojo;
import com.anthony.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	} 
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	public Dojo create(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	public Dojo getDojo(Long dojoId) {
		Optional<Dojo> dojo = dojoRepo.findById(dojoId);
		return dojo.isPresent() ? dojo.get() : null;
	}
}
