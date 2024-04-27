package com.generated.project.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "staff")
public class Staff {

	@Column(name = "password")
	String password;
	@JoinColumn(name = "idaddress")
	@ManyToOne
	Address address;
	@Column(name = "last_update")
	Timestamp lastUpdate;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "active")
	Boolean active;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "email")
	String email;
	@Column(name = "username")
	String username;




	public Staff(){}

	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
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
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public Boolean getActive(){
		return this.active;
	}
	public void setActive(Boolean active){
		this.active = active;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}


}
