package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "city")
public class City {

	@JoinColumn(name = "idcountry")
	@ManyToOne
	Country country;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Column(name = "name")
	String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;




	public City(){}

	public Country getCountry(){
		return this.country;
	}
	public void setCountry(Country country){
		this.country = country;
	}
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
