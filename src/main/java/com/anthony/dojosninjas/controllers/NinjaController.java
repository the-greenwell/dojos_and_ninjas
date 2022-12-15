package com.anthony.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.dojosninjas.models.Dojo;
import com.anthony.dojosninjas.models.Ninja;
import com.anthony.dojosninjas.services.DojoService;
import com.anthony.dojosninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	public NinjaController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	@GetMapping("/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "NewNinja.jsp";
	}
	@PostMapping("/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "NewNinja.jsp";
		}
		ninjaServ.create(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}
