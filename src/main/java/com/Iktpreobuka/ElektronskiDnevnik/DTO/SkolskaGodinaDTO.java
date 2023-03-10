package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class SkolskaGodinaDTO {
	@JsonView(Views.Private.class)
	private int id_sg;
	@JsonView (Views.Private.class)
	@NotNull(message = "Godina mora biti ubacena")
	@Pattern(regexp = "^(20[0-9][0-9])/(20[0-9][0-9])$", message = "Godina mora imati format 20yy/20yy!")	
	private String godina;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> razred_Id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> polugodiste_Id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> predmeti_Id;
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
	public ArrayList<Integer> getRazred_Id() {
		return razred_Id;
	}
	public void setRazred_Id(ArrayList<Integer> razred_Id) {
		this.razred_Id = razred_Id;
	}
	public ArrayList<Integer> getPolugodiste_Id() {
		return polugodiste_Id;
	}
	public void setPolugodiste_Id(ArrayList<Integer> polugodiste_Id) {
		this.polugodiste_Id = polugodiste_Id;
	}
	public ArrayList<Integer> getPredmeti_Id() {
		return predmeti_Id;
	}
	public void setPredmeti_Id(ArrayList<Integer> predmeti_Id) {
		this.predmeti_Id = predmeti_Id;
	}
	public SkolskaGodinaDTO() {
		super();
	}
	public SkolskaGodinaDTO(int id_sg,
			@NotNull(message = "Godina mora biti ubacena") @Pattern(regexp = "^(20[0-9][0-9])/(20[0-9][0-9])$", message = "Godina mora imati format 20yy/20yy!") String godina,
			ArrayList<Integer> razred_Id, ArrayList<Integer> polugodiste_Id, ArrayList<Integer> predmeti_Id) {
		super();
		this.id_sg = id_sg;
		this.godina = godina;
		this.razred_Id = razred_Id;
		this.polugodiste_Id = polugodiste_Id;
		this.predmeti_Id = predmeti_Id;
	}
	
	
	
	
}
