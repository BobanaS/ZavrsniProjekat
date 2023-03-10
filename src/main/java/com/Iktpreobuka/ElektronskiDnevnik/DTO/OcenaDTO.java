package com.Iktpreobuka.ElektronskiDnevnik.DTO;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Ocena_tip;
import com.Iktpreobuka.ElektronskiDnevnik.security.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

public class OcenaDTO {
	@JsonView (Views.Private.class)
	private int id;

	@JsonView (Views.Private.class)
	@NotNull(message = "Ocena mora biti ubacena")
	@Min(value = 1, message = "Minimalna ocena {min}!")
	@Max(value = 5, message = "Maksimalna ocena {max}!")
	private int ocena;

	@JsonView (Views.Private.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Belgrade")
	private Date Datum;
	
	@JsonView (Views.Private.class)
	@NotNull(message = "Mark type must be provided!")
	private Ocena_tip tip_o;

	@JsonView (Views.Private.class)
	@NotNull(message = "Ucenik mora biti ubacen!")
	private int UcenikId;
	
	@JsonView (Views.Private.class)
	@NotNull(message = "Nastavnik mora biti ubacen!")
	private int NastavnikId;

	@JsonView (Views.Private.class)
	@NotNull(message = "Predmet mora biti uacen")
	private int predmetID;

	@JsonView (Views.Private.class)
	@NotNull(message = "Polugodiste mora biti ubaceno!")
	private int PolugodisteID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Date getDatum() {
		return Datum;
	}

	public void setDatum(Date datum) {
		Datum = datum;
	}

	public Ocena_tip getTip_o() {
		return tip_o;
	}

	public void setTip_o(Ocena_tip tip_o) {
		this.tip_o = tip_o;
	}

	public int getUcenikId() {
		return UcenikId;
	}

	public void setUcenikId(int ucenikId) {
		UcenikId = ucenikId;
	}

	public int getNastavnikId() {
		return NastavnikId;
	}

	public void setNastavnikId(int nastavnikId) {
		NastavnikId = nastavnikId;
	}

	public int getPredmetID() {
		return predmetID;
	}

	public void setPredmetID(int predmetID) {
		this.predmetID = predmetID;
	}

	public int getPolugodisteID() {
		return PolugodisteID;
	}

	public void setPolugodisteID(int polugodisteID) {
		PolugodisteID = polugodisteID;
	}

	public OcenaDTO() {
		super();
	}

	public OcenaDTO(int id,
			@NotNull(message = "Ocena mora biti ubacena") @Min(value = 1, message = "Minimalna ocena {min}!") @Max(value = 5, message = "Maksimalna ocena {max}!") int ocena,
			Date datum, @NotNull(message = "Mark type must be provided!") Ocena_tip tip_o,
			@NotNull(message = "Ucenik mora biti ubacen!") int ucenikId,
			@NotNull(message = "Nastavnik mora biti ubacen!") int nastavnikId,
			@NotNull(message = "Predmet mora biti uacen") int predmetID,
			@NotNull(message = "Polugodiste mora biti ubaceno!") int polugodisteID) {
		super();
		this.id = id;
		this.ocena = ocena;
		Datum = datum;
		this.tip_o = tip_o;
		UcenikId = ucenikId;
		NastavnikId = nastavnikId;
		this.predmetID = predmetID;
		PolugodisteID = polugodisteID;
	}

}
