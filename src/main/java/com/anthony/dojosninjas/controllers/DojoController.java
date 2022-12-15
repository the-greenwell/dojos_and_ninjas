package com.anthony.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.dojosninjas.models.Dojo;
import com.anthony.dojosninjas.models.Ninja;
import com.anthony.dojosninjas.services.DojoService;
import com.anthony.dojosninjas.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	public DojoController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	@GetMapping("/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "NewDojo.jsp";
	}
	@PostMapping("/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}
		dojoServ.create(dojo);
		return "redirect:/dojos/" + dojo.getId();
	}
	@GetMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.getDojo(id);
		List<Ninja> ninjas = ninjaServ.findByDojo(dojo);
		model.addAttribute(dojo);
		model.addAttribute("allNinjas", ninjas);
		return "DojoShow.jsp";
	}
	
}
