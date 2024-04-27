package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "film")
public class Film {

	@Column(name = "rental_duration")
	Integer rentalDuration;
	@Column(name = "rental_rate")
	Double rentalRate;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Column(name = "length")
	Integer length;
	@Column(name = "replacement_cost")
	Double replacementCost;
	@Column(name = "description")
	String description;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "title")
	String title;
	@JoinColumn(name = "idlanguage")
	@ManyToOne
	Language language;




	public Film(){}

	public Integer getRentalDuration(){
		return this.rentalDuration;
	}
	public void setRentalDuration(Integer rentalDuration){
		this.rentalDuration = rentalDuration;
	}
	public Double getRentalRate(){
		return this.rentalRate;
	}
	public void setRentalRate(Double rentalRate){
		this.rentalRate = rentalRate;
	}
	public Timestamp getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Integer getLength(){
		return this.length;
	}
	public void setLength(Integer length){
		this.length = length;
	}
	public Double getReplacementCost(){
		return this.replacementCost;
	}
	public void setReplacementCost(Double replacementCost){
		this.replacementCost = replacementCost;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public Language getLanguage(){
		return this.language;
	}
	public void setLanguage(Language language){
		this.language = language;
	}


}
