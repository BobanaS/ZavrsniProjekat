package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Nastavnik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Nastavnik_Repository;

@Service
public class NastavnikServiceImpl implements NastavnikService {

@Autowired
private Nastavnik_Repository NastavniRepo;
	
	
	@Override
	public List<Nastavnik_Entity> getAllNastavnike() {
		List<Nastavnik_Entity> nastavnici = (List<Nastavnik_Entity>) NastavniRepo.findAll();
		return nastavnici;
	}

	@Override
	public Nastavnik_Entity findNastavnikById(int id) {
		Optional<Nastavnik_Entity> nastavnik = NastavniRepo.findById(id);
		if (nastavnik.isPresent()) {
			return nastavnik.get();
		} else {
			return null;
		}
	}

	@Override
	public Nastavnik_Entity saveNastavnik(Nastavnik_Entity nastavnik) {
		try {
			return NastavniRepo.save(nastavnik);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Nastavnik_Entity updateNastavnik(Nastavnik_Entity nastavnik, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeNastavnik(int id) {
		Optional<Nastavnik_Entity> n = NastavniRepo.findById(id);
		if (n.isPresent()) {
			NastavniRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Nastavnik_Entity> getAllNastavnikByID(ArrayList<Integer> id) {
			ArrayList<Nastavnik_Entity> nastavnici = new ArrayList<>();

		for (int NastavnikId : id) {
			Optional<Nastavnik_Entity> indbNastavnik = NastavniRepo.findById(NastavnikId);
			if (indbNastavnik.isPresent()) {
				nastavnici.add(indbNastavnik.get());
			} else {
				return null;
			}
		}
		return nastavnici;
	}
}
