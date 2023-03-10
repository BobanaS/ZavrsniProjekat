package com.Iktpreobuka.ElektronskiDnevnik.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ucenici")
public class Ucenik_Entity {
	@Id
	@GeneratedValue
	@Column(name = "Ucenici_id")
	private int id_ucenika;
	@Column(name = "ime")
	private String ime;
	@Column (name= "prezime")
	private String prezime;
	@Column (name = "role")
	private User_role role;
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private Korisnik korisnik;	
	@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name = "Roditelj", nullable = false)
	private Roditelj_Entity roditelj;
	@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name = "razred")
	private Razred_Entity razred;
	@OneToMany (/*mappedBy = "student",*/ fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private List<Ocena_Entity> ocene = new ArrayList<>();
	public int getId_ucenika() {
		return id_ucenika;
	}
	public void setId_ucenika(int id_ucenika) {
		this.id_ucenika = id_ucenika;
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
	public User_role getRole() {
		return role;
	}
	public void setRole(User_role role) {
		this.role = role;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Roditelj_Entity getRoditelj() {
		return roditelj;
	}
	public void setRoditelj(Roditelj_Entity roditelj) {
		this.roditelj = roditelj;
	}
	public Razred_Entity getRazred() {
		return razred;
	}
	public void setRazred(Razred_Entity razred) {
		this.razred = razred;
	}
	public List<Ocena_Entity> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena_Entity> ocene) {
		this.ocene = ocene;
	}
	public Ucenik_Entity(int id_ucenika, String ime, String prezime, User_role role, Korisnik korisnik,
			Roditelj_Entity roditelj, Razred_Entity razred, List<Ocena_Entity> ocene) {
		super();
		this.id_ucenika = id_ucenika;
		this.ime = ime;
		this.prezime = prezime;
		this.role = role;
		this.korisnik = korisnik;
		this.roditelj = roditelj;
		this.razred = razred;
		this.ocene = ocene;
	}



}