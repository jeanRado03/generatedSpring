package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "address")
public class Address {

	@Column(name = "address2")
	String address2;
	@Column(name = "phone")
	String phone;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Column(name = "name")
	String name;
	@JoinColumn(name = "idcity")
	@ManyToOne
	City city;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "postal_code")
	String postalCode;




	public Address(){}

	public String getAddress2(){
		return this.address2;
	}
	public void setAddress2(String address2){
		this.address2 = address2;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
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
	public City getCity(){
		return this.city;
	}
	public void setCity(City city){
		this.city = city;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}


}
