package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class PredmetDTO {
	@JsonView (Views.Private.class)
	private int id_P;
	@JsonView (Views.Public.class)
	@NotNull(message = "Naziv mora postojati")
	@Size(min = 2, max = 20, message = "Naziv mora imati izmedju {min} and {max} karaktera!")
	private String naziv;
	@JsonView (Views.Private.class)
	@NotNull(message = "Fond must be provided!")
	@Min(value = 5, message = "Fond mora biti {min} casova!")
	@Max(value = 12, message = "Fond mora biti {max} casova!")
	private int fondN;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> razred_id;
	@JsonView (Views.Private.class)
	@NotNull(message = "Skolska godina mora biti ubacena!")
	private int Skolskagodina_id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> ocene_id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> Nastavnici_id;
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
	public ArrayList<Integer> getRazred_id() {
		return razred_id;
	}
	public void setRazred_id(ArrayList<Integer> razred_id) {
		this.razred_id = razred_id;
	}
	public int getSkolskagodina_id() {
		return Skolskagodina_id;
	}
	public void setSkolskagodina_id(int skolskagodina_id) {
		Skolskagodina_id = skolskagodina_id;
	}
	public ArrayList<Integer> getOcene_id() {
		return ocene_id;
	}
	public void setOcene_id(ArrayList<Integer> ocene_id) {
		this.ocene_id = ocene_id;
	}
	public ArrayList<Integer> getNastavnici_id() {
		return Nastavnici_id;
	}
	public void setNastavnici_id(ArrayList<Integer> nastavnici_id) {
		Nastavnici_id = nastavnici_id;
	}
	public PredmetDTO() {
		super();
	}
	public PredmetDTO(int id_P,
			@NotNull(message = "Naziv mora postojati") @Size(min = 2, max = 20, message = "Naziv mora imati izmedju {min} and {max} karaktera!") String naziv,
			@NotNull(message = "Fond must be provided!") @Min(value = 5, message = "Fond mora biti {min} casova!") @Max(value = 12, message = "Fond mora biti {max} casova!") int fondN,
			ArrayList<Integer> razred_id, @NotNull(message = "Skolska godina mora biti ubacena!") int skolskagodina_id,
			ArrayList<Integer> ocene_id, ArrayList<Integer> nastavnici_id) {
		super();
		this.id_P = id_P;
		this.naziv = naziv;
		this.fondN = fondN;
		this.razred_id = razred_id;
		Skolskagodina_id = skolskagodina_id;
		this.ocene_id = ocene_id;
		Nastavnici_id = nastavnici_id;
	}

	
	}

