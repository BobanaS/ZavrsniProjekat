package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Ocena_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.SkolskaGodina_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

public class PolugodisteDTO {
	@JsonView (Views.Private.class)
	private int id_po;
	@JsonView (Views.Private.class)
	@NotNull(message="Polugodiste mora imati redni broj")
	@Range (min = 1, max = 2, message = "Moze biti samo {min} ili {max}!")
	private int rbrp;
	@JsonView (Views.Private.class)
	@NotNull (message="Datum mora biti ubacen")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Belgrade")
	private Date datumPocetka;
	@JsonView (Views.Private.class)
	@NotNull (message="Datum mora biti ubacen")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Belgrade")
	private Date datumKraja;
	@JsonView (Views.Private.class)
	@NotNull (message="Moras da dodas skolsku godinu")
	private int skolskagodina_id;
	@JsonView (Views.Private.class)
	private ArrayList<Integer> ocene_ID;
	public int getId_po() {
		return id_po;
	}
	public void setId_po(int id_po) {
		this.id_po = id_po;
	}
	public int getRbrp() {
		return rbrp;
	}
	public void setRbrp(int rbrp) {
		this.rbrp = rbrp;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Date getDatumKraja() {
		return datumKraja;
	}
	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}
	public int getSkolskagodina_id() {
		return skolskagodina_id;
	}
	public void setSkolskagodina_id(int skolskagodina_id) {
		this.skolskagodina_id = skolskagodina_id;
	}
	public ArrayList<Integer> getOcene_ID() {
		return ocene_ID;
	}
	public void setOcene_ID(ArrayList<Integer> ocene_ID) {
		this.ocene_ID = ocene_ID;
	}
	public PolugodisteDTO() {
		super();
	}
	public PolugodisteDTO(int id_po,
			@NotNull(message = "Polugodiste mora imati redni broj") @Range(min = 1, max = 2, message = "Moze biti samo {min} ili {max}!") int rbrp,
			@NotNull(message = "Datum mora biti ubacen") Date datumPocetka,
			@NotNull(message = "Datum mora biti ubacen") Date datumKraja,
			@NotNull(message = "Moras da dodas skolsku godinu") int skolskagodina_id, ArrayList<Integer> ocene_ID) {
		super();
		this.id_po = id_po;
		this.rbrp = rbrp;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.skolskagodina_id = skolskagodina_id;
		this.ocene_ID = ocene_ID;
	}
	
	
	
}
