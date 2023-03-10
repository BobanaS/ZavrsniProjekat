package com.Iktpreobuka.ElektronskiDnevnik.entities;

public class Email {
	private String Roditelj_email;
	private String Ime_Ucenika;
	private String Prezime_Ucenika;
	private Integer Ocena;
	private Ocena_tip Tip_ocene;
	private String ImePredmeta;
	private String ImeNastavnika;
	private String PrezimeNastavnika;
	public String getRoditelj_email() {
		return Roditelj_email;
	}
	public void setRoditelj_email(String roditelj_email) {
		Roditelj_email = roditelj_email;
	}
	public String getIme_Ucenika() {
		return Ime_Ucenika;
	}
	public void setIme_Ucenika(String ime_Ucenika) {
		Ime_Ucenika = ime_Ucenika;
	}
	public String getPrezime_Ucenika() {
		return Prezime_Ucenika;
	}
	public void setPrezime_Ucenika(String prezime_Ucenika) {
		Prezime_Ucenika = prezime_Ucenika;
	}
	public Integer getOcena() {
		return Ocena;
	}
	public void setOcena(Integer ocena) {
		Ocena = ocena;
	}
	public Ocena_tip getTip_ocene() {
		return Tip_ocene;
	}
	public void setTip_ocene(Ocena_tip tip_ocene) {
		Tip_ocene = tip_ocene;
	}
	public String getImePredmeta() {
		return ImePredmeta;
	}
	public void setImePredmeta(String imePredmeta) {
		ImePredmeta = imePredmeta;
	}
	public String getImeNastavnika() {
		return ImeNastavnika;
	}
	public void setImeNastavnika(String imeNastavnika) {
		ImeNastavnika = imeNastavnika;
	}
	public String getPrezimeNastavnika() {
		return PrezimeNastavnika;
	}
	public void setPrezimeNastavnika(String prezimeNastavnika) {
		PrezimeNastavnika = prezimeNastavnika;
	}
	public Email() {
		super();
	}
	public Email(String roditelj_email, String ime_Ucenika, String prezime_Ucenika, Integer ocena, Ocena_tip tip_ocene,
			String imePredmeta, String imeNastavnika, String prezimeNastavnika) {
		super();
		Roditelj_email = roditelj_email;
		Ime_Ucenika = ime_Ucenika;
		Prezime_Ucenika = prezime_Ucenika;
		Ocena = ocena;
		Tip_ocene = tip_ocene;
		ImePredmeta = imePredmeta;
		ImeNastavnika = imeNastavnika;
		PrezimeNastavnika = prezimeNastavnika;
	}
	

	
}

