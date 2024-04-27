package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "inventory")
public class Inventory {

	@JoinColumn(name = "idfilm")
	@ManyToOne
	Film film;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@JoinColumn(name = "idstore")
	@ManyToOne
	Store store;




	public Inventory(){}

	public Film getFilm(){
		return this.film;
	}
	public void setFilm(Film film){
		this.film = film;
	}
	public Timestamp getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Store getStore(){
		return this.store;
	}
	public void setStore(Store store){
		this.store = store;
	}


}
