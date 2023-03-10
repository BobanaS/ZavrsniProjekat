package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Razred_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class RazredDTO {
	@JsonView(Views.Private.class)
	private int id_r;
	@JsonView(Views.Private.class)
	@NotNull(message = "Odeljenje mora biti ubaceno!")
	@Size(max = 8, message = "Odeljenje moze imati {max} slova!")
	private String naziv;
	@JsonView(Views.Private.class)
	private ArrayList<Integer> ucenici_ID;
	@JsonView(Views.Private.class)
	@NotNull(message = "Skolska godina mora biti odredjena")
	private int schoolYearID;
	@JsonView(Views.Private.class)
	private ArrayList<Integer> Predmet_ID;
	public int getId_r() {
		return id_r;
	}
	public void setId_r(int id_r) {
		this.id_r = id_r;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Integer> getUcenici_ID() {
		return ucenici_ID;
	}
	public void setUcenici_ID(ArrayList<Integer> ucenici_ID) {
		this.ucenici_ID = ucenici_ID;
	}
	public int getSchoolYearID() {
		return schoolYearID;
	}
	public void setSchoolYearID(int schoolYearID) {
		this.schoolYearID = schoolYearID;
	}
	public ArrayList<Integer> getPredmet_ID() {
		return Predmet_ID;
	}
	public void setPredmet_ID(ArrayList<Integer> predmet_ID) {
		Predmet_ID = predmet_ID;
	}
	public RazredDTO() {
		super();
	}
	public RazredDTO(int id_r,
			@NotNull(message = "Odeljenje mora biti ubaceno!") @Size(max = 8, message = "Odeljenje moze imati {max} slova!") String naziv,
			ArrayList<Integer> ucenici_ID, @NotNull(message = "Skolska godina mora biti odredjena") int schoolYearID,
			ArrayList<Integer> predmet_ID) {
		super();
		this.id_r = id_r;
		this.naziv = naziv;
		this.ucenici_ID = ucenici_ID;
		this.schoolYearID = schoolYearID;
		Predmet_ID = predmet_ID;
	}
	public RazredDTO(Razred_Entity cls) {
		// TODO Auto-generated constructor stub
	}





}
