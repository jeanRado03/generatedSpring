package com.generated.project.entity;


import com.generated.project.repository.UtilisateurRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {

	@Id
	@Column(name = "id")
	String id;
	private String nom;
	private String prenom;
	@Column(name = "datenaissance")
	Date datenaissance;
	private String email;
	private String phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

	public String getId_user() {
		return id;
	}

	public void setId_user(String id_user) {
		this.id = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return datenaissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.datenaissance = date_naissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public static Utilisateur getOptionalUserById(String id, UtilisateurRepository utilisateurRepository) throws Exception {
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
		if(optionalUtilisateur.isPresent()){
			return optionalUtilisateur.get();
		}
		throw new Exception("utilisateur inexistant");
	}


	public HashMap<String,Object> getNometPrenomIdUtilisateur(){
		HashMap<String,Object> utilisateur=new HashMap<>();
		utilisateur.put("id_user",this.getId_user());
		utilisateur.put("nom",this.getNom());
		utilisateur.put("prenom",this.getPrenom());
		return utilisateur;
	}


}
