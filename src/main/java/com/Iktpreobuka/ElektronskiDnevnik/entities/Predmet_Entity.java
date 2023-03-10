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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Predmet")
public class Predmet_Entity {
	@Id
	@GeneratedValue
	@Column(name = "Predmet_id")
	private int id_P;
	@Column(name = "Naziv")
	private String naziv;
	@Column(name = "Fond casova")
	private int fondN;
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "predmet - razred", joinColumns = {
			@JoinColumn(name = "predmet_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "razred_id", nullable = false, updatable = false) })
	private List<Razred_Entity> razredi = new ArrayList<>();
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "Skolska_godina", nullable = false)
	private SkolskaGodina_Entity S_godina;
	@OneToMany(/*	mappedBy = "predmet",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ocena_Entity> ocene = new ArrayList<>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "predmet - nastavnik", joinColumns = {
			@JoinColumn(name = "Predmet_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) })
	private List<Nastavnik_Entity> Nastavnik = new ArrayList<>();

	public int getId_P() {
		return id_P;
	}

	public void setId_P(int id_P) {
		this.id_P = id_P;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getFondN() {
		return fondN;
	}

	public void setFondN(int fondN) {
		this.fondN = fondN;
	}

	public List<Razred_Entity> getRazredi() {
		return razredi;
	}

	public void setRazredi(List<Razred_Entity> razredi) {
		this.razredi = razredi;
	}

	public SkolskaGodina_Entity getS_godina() {
		return S_godina;
	}

	public void setS_godina(SkolskaGodina_Entity s_godina) {
		S_godina = s_godina;
	}

	public List<Ocena_Entity> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena_Entity> ocene) {
		this.ocene = ocene;
	}

	public List<Nastavnik_Entity> getNastavnik() {
		return Nastavnik;
	}

	public void setNastavnik(List<Nastavnik_Entity> nastavnik) {
		Nastavnik = nastavnik;
	}

	public Predmet_Entity() {
		super();
	}

	public Predmet_Entity(int id_P, String naziv, int fondN, List<Razred_Entity> razredi, SkolskaGodina_Entity s_godina,
			List<Ocena_Entity> ocene, List<Nastavnik_Entity> nastavnik) {
		super();
		this.id_P = id_P;
		this.naziv = naziv;
		this.fondN = fondN;
		this.razredi = razredi;
		S_godina = s_godina;
		this.ocene = ocene;
		Nastavnik = nastavnik;
	}

}