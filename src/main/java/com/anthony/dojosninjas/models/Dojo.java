package com.anthony.dojosninjas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dojos")
public class Dojo {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dojoId;
	private String name;
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	public Dojo() {
	}
	public Dojo(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	// getters and setters
	public Long getId() {
		return dojoId;
	}
	public void setId(Long id) {
		this.dojoId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
}