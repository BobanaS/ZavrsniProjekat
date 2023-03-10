package com.Iktpreobuka.ElektronskiDnevnik.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.access.annotation.Secured;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "korisnici")
@JsonIgnoreProperties({"handler", "hibernateLazyInializer"})
public class Korisnik {
@Id
@GeneratedValue
@Column(name = "id_korisnika")
private int id_k;
@Column(name= "Korisnicko ime")
private String korisnicko_ime;
@JsonIgnore
@Column(name = "Sifra")
private String sifra;
@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
@JoinColumn(name="role")
private Role_Entity role;
public String getKorisnicko_ime() {
	return korisnicko_ime;
}
public void setKorisnicko_ime(String korisnicko_ime) {
	this.korisnicko_ime = korisnicko_ime;
}
public String getSifra() {
	return sifra;
}
public void setSifra(String sifra) {
	this.sifra = sifra;
}
public int getId_k() {
	return id_k;
}
public void setId_k(int id_k) {
	this.id_k = id_k;
}


public Role_Entity getRole() {
	return role;
}
public void setRole(Role_Entity role) {
	this.role = role;
}
public Korisnik() {
	super();
}
public Korisnik(int id_k, String korisnicko_ime, String sifra, Role_Entity role) {
	super();
	this.id_k = id_k;
	this.korisnicko_ime = korisnicko_ime;
	this.sifra = sifra;
	this.role = role;
}



}
