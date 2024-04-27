package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "country")
public class Country {

	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Column(name = "name")
	String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;




	public Country(){}

	public Timestamp getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}


}
