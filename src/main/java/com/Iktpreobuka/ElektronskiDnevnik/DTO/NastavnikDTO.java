package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class NastavnikDTO {
	@JsonView(Views.Private.class)
	private int id_n;
	@JsonView (Views.Private.class)
	@NotNull(message="Ime mora biti ubaceno")
	@Size (min = 2, max = 20, message = "Ime mora biti izmedju {min} i {max} karaktera!")
	private String ime;
	@JsonView (Views.Private.class)
	@NotNull(message="Prezime mora biti ubaceno")
	@Size (min = 2, max = 20, message = "Prezime mora biti {min} i {max} karaktera!")
	private String prezime;	
	
	@JsonView (Views.Private.class)
	private ArrayList<Integer> Predmet_ids;
	
	@JsonView (Views.Private.class)
	private ArrayList<Integer> Ocene_ids;

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

	public ArrayList<Integer> getPredmet_ids() {
		return Predmet_ids;
	}

	public void setPredmet_ids(ArrayList<Integer> predmet_ids) {
		Predmet_ids = predmet_ids;
	}

	public ArrayList<Integer> getOcene_ids() {
		return Ocene_ids;
	}

	public void setOcene_ids(ArrayList<Integer> ocene_ids) {
		Ocene_ids = ocene_ids;
	}

	public NastavnikDTO() {
		super();
	}

	public NastavnikDTO(int id_n,
			@NotNull(message = "Ime mora biti ubaceno") @Size(min = 2, max = 20, message = "Ime mora biti izmedju {min} i {max} karaktera!") String ime,
			@NotNull(message = "Prezime mora biti ubaceno") @Size(min = 2, max = 20, message = "Prezime mora biti {min} i {max} karaktera!") String prezime,
			ArrayList<Integer> predmet_ids, ArrayList<Integer> ocene_ids) {
		super();
		this.id_n = id_n;
		this.ime = ime;
		this.prezime = prezime;
		Predmet_ids = predmet_ids;
		Ocene_ids = ocene_ids;
	}

	
}

