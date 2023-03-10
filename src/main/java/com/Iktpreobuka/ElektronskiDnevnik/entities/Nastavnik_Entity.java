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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Nastavnik")
public class Nastavnik_Entity {
	@Id
	@GeneratedValue
	@Column(name = "Nastavnik_id")
	private int id_n;
	@Column(name = "ime")
	private String ime;
	@Column (name= "prezime")
	private String prezime;
	@Column (name = "role")
	private User_role role;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "predmet-nastavnik", joinColumns = {
			@JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "predmet_id", nullable = false, updatable = false) })
	private List<Predmet_Entity> Predmeti = new ArrayList<>();
	@OneToMany(/*mappedBy = "Nastavnik",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ocena_Entity> ocene = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private Korisnik korisnik;
	public int getId_n() {
		return id_n;
	}
	public void setId_n(int id_n) {
		this.id_n = id_n;
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
	public List<Predmet_Entity> getPredmeti() {
		return Predmeti;
	}
	public void setPredmeti(List<Predmet_Entity> predmeti) {
		Predmeti = predmeti;
	}
	public List<Ocena_Entity> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena_Entity> ocene) {
		this.ocene = ocene;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Nastavnik_Entity() {
		super();
	}
	public Nastavnik_Entity(int id_n, String ime, String prezime, User_role role, List<Predmet_Entity> predmeti,
			List<Ocena_Entity> ocene, Korisnik korisnik) {
		super();
		this.id_n = id_n;
		this.ime = ime;
		this.prezime = prezime;
		this.role = role;
		Predmeti = predmeti;
		this.ocene = ocene;
		this.korisnik = korisnik;
	}
	

}

