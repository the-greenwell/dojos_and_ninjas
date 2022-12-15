package com.anthony.dojosninjas.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.dojosninjas.models.Dojo;
import com.anthony.dojosninjas.services.DojoService;
import com.anthony.dojosninjas.services.NinjaService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final DojoService dojoServ;
	public ApiController(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}
	@GetMapping("/dojos/{id}")
	public Dojo getDojo(@PathVariable("id") Long id) {
		return dojoServ.getDojo(id);
	}
	@PostMapping("/dojos")
	public Dojo create(@RequestParam("name") String name) {
		Dojo dojo = new Dojo(name);
		return dojoServ.create(dojo);
	}
	@GetMapping("/dojos")
	public List<Dojo> getDojos(){
		return dojoServ.findAll();
	}
}
