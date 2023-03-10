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
import javax.persistence.Table;

@Entity
@Table(name = "Skolska godina")
public class SkolskaGodina_Entity {
	@Id
	@GeneratedValue
	@Column(name = "id_skolske_godine")
	private int id_sg;
	@Column(name = "Godina", nullable = false, unique = true)
	private String godina;
	@OneToMany(/*mappedBy = "SkolskaGodina",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Razred_Entity> razred = new ArrayList<>();
	@OneToMany(/*mappedBy = "SkolskaGodina",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Polugodiste_Entity> polugodiste = new ArrayList<>();
	@OneToMany(/*mappedBy = "SkolskaGodina",*/ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Predmet_Entity> predmet = new ArrayList<>();
	public int getId_sg() {
		return id_sg;
	}
	public void setId_sg(int id_sg) {
		this.id_sg = id_sg;
	}
	public String getGodina() {
		return godina;
	}
	public void setGodina(String godina) {
		this.godina = godina;
	}
	public List<Razred_Entity> getRazred() {
		return razred;
	}
	public void setRazred(List<Razred_Entity> razred) {
		this.razred = razred;
	}
	public List<Polugodiste_Entity> getPolugodiste() {
		return polugodiste;
	}
	public void setPolugodiste(List<Polugodiste_Entity> polugodiste) {
		this.polugodiste = polugodiste;
	}
	public List<Predmet_Entity> getPredmet() {
		return predmet;
	}
	public void setPredmet(List<Predmet_Entity> predmet) {
		this.predmet = predmet;
	}
	public SkolskaGodina_Entity() {
		super();
	}
	public SkolskaGodina_Entity(int id_sg, String godina, List<Razred_Entity> razred,
			List<Polugodiste_Entity> polugodiste, List<Predmet_Entity> predmet) {
		super();
		this.id_sg = id_sg;
		this.godina = godina;
		this.razred = razred;
		this.polugodiste = polugodiste;
		this.predmet = predmet;
	}

	
}
