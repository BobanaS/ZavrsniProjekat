package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class UcenikDTO {
	@JsonView (Views.Public.class)
	private int id_ucenika;
	@JsonView (Views.Private.class)
	@NotNull(message = "Ime mora biti ubaceno!")
	@Size(min = 2, max = 20, message = "Ime mora imati {min} i {max} karaktera!")
	private String ime;
	@JsonView (Views.Private.class)
	@NotNull(message = "Prezime mora biti ubaceno!")
	@Size(min = 2, max = 20, message = "Prezime mora imati {min} i {max} karaktera!")
	private String prezime;
	@JsonView (Views.Private.class)
	@NotNull(message="Moras da dodas roditelja!")
	private int roditelj_Id;
	@JsonView (Views.Private.class)
	private int razred_id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> ocene;
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
	public int getRoditelj_Id() {
		return roditelj_Id;
	}
	public void setRoditelj_Id(int roditelj_Id) {
		this.roditelj_Id = roditelj_Id;
	}
	public int getRazred_id() {
		return razred_id;
	}
	public void setRazred_id(int razred_id) {
		this.razred_id = razred_id;
	}
	public ArrayList<Integer> getOcene() {
		return ocene;
	}
	public void setOcene(ArrayList<Integer> ocene) {
		this.ocene = ocene;
	}
	public UcenikDTO() {
		super();
	}
	public UcenikDTO(int id_ucenika,
			@NotNull(message = "Ime mora biti ubaceno!") @Size(min = 2, max = 20, message = "Ime mora imati {min} i {max} karaktera!") String ime,
			@NotNull(message = "Prezime mora biti ubaceno!") @Size(min = 2, max = 20, message = "Prezime mora imati {min} i {max} karaktera!") String prezime,
			@NotNull(message = "Moras da dodas roditelja!") int roditelj_Id, int razred_id, ArrayList<Integer> ocene) {
		super();
		this.id_ucenika = id_ucenika;
		this.ime = ime;
		this.prezime = prezime;
		this.roditelj_Id = roditelj_Id;
		this.razred_id = razred_id;
		this.ocene = ocene;
	}

}
