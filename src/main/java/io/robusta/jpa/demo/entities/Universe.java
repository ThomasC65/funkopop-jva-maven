package io.robusta.jpa.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity //donc on creé une table
public class Universe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@NotNull
	@Size(min=3, max=50)
	String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Universe(){
		
	}

	public Universe(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
