package com.Iktpreobuka.ElektronskiDnevnik.DTO;

public class KorisnikDTO {
	private String korisnik;
	private String token;

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public KorisnikDTO() {
		super();
	}

	public KorisnikDTO(String korisnik, String token) {
		super();
		this.korisnik = korisnik;
		this.token = token;
	}

}
