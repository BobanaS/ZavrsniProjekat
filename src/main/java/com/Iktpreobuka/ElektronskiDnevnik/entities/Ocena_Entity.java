package com.Iktpreobuka.ElektronskiDnevnik.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ocena")
public class Ocena_Entity {
@Id
@GeneratedValue
@Column(name="Id_Ocena")
private int id_o;
@Column(name="Vrednost", nullable = false)
private int ocena;
@Column (name = "Tip ocene", nullable = false)
private Ocena_tip tip_o;
@Column (name = "Datum")
private Date datum;
@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
@JoinColumn(name = "Polugodiste", nullable = false)
private Polugodiste_Entity polugodiste;
@ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
@JoinColumn(name = "Nastavnik", nullable = false)
private Nastavnik_Entity nastavnik;
@ManyToOne (cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
@JoinColumn(name = "Predmet", nullable = false)
private Predmet_Entity predmet;
@ManyToOne (cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
@JoinColumn(name = "Ucenik", nullable = false)
private Ucenik_Entity ucenik;
public int getId_o() {
	return id_o;
}
public void setId_o(int id_o) {
	this.id_o = id_o;
}
public int getOcena() {
	return ocena;
}
public void setOcena(int ocena) {
	this.ocena = ocena;
}
public Ocena_tip getTip_o() {
	return tip_o;
}
public void setTip_o(Ocena_tip tip_o) {
	this.tip_o = tip_o;
}
public Date getDatum() {
	return datum;
}
public void setDatum(Date datum) {
	this.datum = datum;
}
public Polugodiste_Entity getPolugodiste() {
	return polugodiste;
}
public void setPolugodiste(Polugodiste_Entity polugodiste) {
	this.polugodiste = polugodiste;
}
public Nastavnik_Entity getNastavnik() {
	return nastavnik;
}
public void setNastavnik(Nastavnik_Entity nastavnik) {
	this.nastavnik = nastavnik;
}
public Predmet_Entity getPredmet() {
	return predmet;
}
public void setPredmet(Predmet_Entity predmet) {
	this.predmet = predmet;
}
public Ucenik_Entity getUcenik() {
	return ucenik;
}
public void setUcenik(Ucenik_Entity ucenik) {
	this.ucenik = ucenik;
}
public Ocena_Entity() {
	super();
}
public Ocena_Entity(int id_o, int ocena, Ocena_tip tip_o, Date datum, Polugodiste_Entity polugodiste,
		Nastavnik_Entity nastavnik, Predmet_Entity predmet, Ucenik_Entity ucenik) {
	super();
	this.id_o = id_o;
	this.ocena = ocena;
	this.tip_o = tip_o;
	this.datum = datum;
	this.polugodiste = polugodiste;
	this.nastavnik = nastavnik;
	this.predmet = predmet;
	this.ucenik = ucenik;
}



}
