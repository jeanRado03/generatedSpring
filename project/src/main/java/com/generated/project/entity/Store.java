package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "store")
public class Store {

	@JoinColumn(name = "idaddress")
	@ManyToOne
	Address address;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@JoinColumn(name = "idstaff")
	@ManyToOne
	Staff staff;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;




	public Store(){}

	public Address getAddress(){
		return this.address;
	}
	public void setAddress(Address address){
		this.address = address;
	}
	public Timestamp getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Staff getStaff(){
		return this.staff;
	}
	public void setStaff(Staff staff){
		this.staff = staff;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}


}
