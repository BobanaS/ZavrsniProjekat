package com.Iktpreobuka.ElektronskiDnevnik.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "polugodiste")
public class Polugodiste_Entity {
	@Id
	@GeneratedValue
	@Column(name = "polugodiste_id")
	private int id_po;
	@Column(name = "polugodiste po redu")
	private int rbrp;
	@Column(name = "datumPocetka")
	private Date datumPocetka;
	@Column(name = "datumKraja")
	private Date datumKraja;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "Skolska_godina", nullable = false)
	private SkolskaGodina_Entity skolskagodina;
	@OneToMany(/* mappedBy = "polugodiste", */ fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ocena_Entity> ocene = new ArrayList<>();

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

	public SkolskaGodina_Entity getSkolskagodina() {
		return skolskagodina;
	}

	public void setSkolskagodina(SkolskaGodina_Entity skolskagodina) {
		this.skolskagodina = skolskagodina;
	}

	public List<Ocena_Entity> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena_Entity> ocene) {
		this.ocene = ocene;
	}

	public Polugodiste_Entity() {
		super();
	}

	public Polugodiste_Entity(int id_po, int rbrp, Date datumPocetka, Date datumKraja,
			SkolskaGodina_Entity skolskagodina, List<Ocena_Entity> ocene) {
		super();
		this.id_po = id_po;
		this.rbrp = rbrp;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.skolskagodina = skolskagodina;
		this.ocene = ocene;
	}

}
