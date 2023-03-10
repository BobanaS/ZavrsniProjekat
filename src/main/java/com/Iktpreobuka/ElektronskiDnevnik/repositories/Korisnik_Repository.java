package com.Iktpreobuka.ElektronskiDnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Korisnik;

public interface Korisnik_Repository extends CrudRepository<Korisnik, Integer> {
public  Korisnik findByKorisnickoime(String korisnicko_ime);
} 
