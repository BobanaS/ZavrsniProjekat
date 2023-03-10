package com.Iktpreobuka.ElektronskiDnevnik.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roditelj")
public class Roditelj_Entity {
	@Id
	@GeneratedValue
	@Column(name = "Roditelj_id")
	private int id_rod;
	@Column(name = "ime")
	private String ime;
	@Column (name= "prezime")
	private String prezime;
	@Column(name = "email")
	private String email;
	@Column (name = "role")
	private User_role role;
	@OneToMany(/*mappedBy = "roditelj"	,*/fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private List<Ucenik_Entity> ucenici = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private Korisnik korisnik;
	public int getId_rod() {
		return id_rod;
	}
	public void setId_rod(int id_rod) {
		this.id_rod = id_rod;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User_role getRole() {
		return role;
	}
	public void setRole(User_role role) {
		this.role = role;
	}
	public List<Ucenik_Entity> getUcenici() {
		return ucenici;
	}
	public void setUcenici(List<Ucenik_Entity> ucenici) {
		this.ucenici = ucenici;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Roditelj_Entity() {
		super();
	}
	public Roditelj_Entity(int id_rod, String ime, String prezime, String email, User_role role,
			List<Ucenik_Entity> ucenici, Korisnik korisnik) {
		super();
		this.id_rod = id_rod;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.role = role;
		this.ucenici = ucenici;
		this.korisnik = korisnik;
	}
	
	
	
	
}
