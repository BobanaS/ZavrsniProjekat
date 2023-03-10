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
import javax.validation.Valid;

import com.Iktpreobuka.ElektronskiDnevnik.DTO.RazredDTO;

@Entity
@Table (name ="Razred")
public class Razred_Entity {
	@Id
	@GeneratedValue
	@Column(name="razred_id")
	private int id_r;
	@Column (name ="version")
	private int version;
	@Column(name = "Odeljenje")
	private String naziv;
	@OneToMany(/*mappedBy = "razred",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ucenik_Entity> ucenici;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "Skolska godina", nullable = false)
	private SkolskaGodina_Entity SkolskaGodina;
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "predmet - razred", joinColumns = {
			@JoinColumn(name = "razred_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "predmet_id", nullable = false, updatable = false) })
	private List<Predmet_Entity> predmet ;
	public int getId_r() {
		return id_r;
	}
	public void setId_r(int id_r) {
		this.id_r = id_r;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Ucenik_Entity> getUcenici() {
		return ucenici;
	}
	public void setUcenici(List<Ucenik_Entity> ucenici) {
		this.ucenici = ucenici;
	}
	public SkolskaGodina_Entity getSkolskaGodina() {
		return SkolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina_Entity skolskaGodina) {
		SkolskaGodina = skolskaGodina;
	}
	public List<Predmet_Entity> getPredmet() {
		return predmet;
	}
	public void setPredmet(List<Predmet_Entity> predmet) {
		this.predmet = predmet;
	}
	public Razred_Entity() {
		super();
	}
	public Razred_Entity(int id_r, int version, String naziv, List<Ucenik_Entity> ucenici,
			SkolskaGodina_Entity skolskaGodina, List<Predmet_Entity> predmet) {
		super();
		this.id_r = id_r;
		this.version = version;
		this.naziv = naziv;
		this.ucenici = ucenici;
		SkolskaGodina = skolskaGodina;
		this.predmet = predmet;
	}
	public Razred_Entity(@Valid RazredDTO razredDTO, SkolskaGodina_Entity sk, ArrayList<Predmet_Entity> predmeti,
			ArrayList<Ucenik_Entity> ucenici2) {
		// TODO Auto-generated constructor stub
	}


	
	
	}


