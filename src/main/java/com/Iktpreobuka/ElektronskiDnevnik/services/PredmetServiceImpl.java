package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Predmet_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Predmet_Repository;

@Service
public class PredmetServiceImpl implements PredmetService {
	@Autowired
	private Predmet_Repository PreRepo;

	@Override
	public List<Predmet_Entity> getAllPredmete() {
		List<Predmet_Entity> predmeti = (List<Predmet_Entity>) PreRepo.findAll();
		return predmeti;
	}

	@Override
	public Predmet_Entity findPredmeteById(int id) {
		Optional<Predmet_Entity> p = PreRepo.findById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	@Override
	public Predmet_Entity savePredmete(Predmet_Entity PredmetEntity) {
		try {
			return PreRepo.save(PredmetEntity);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Predmet_Entity editPredmete(Predmet_Entity predmet, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePredmete(int id) {
		Optional<Predmet_Entity> p = PreRepo.findById(id);
		if (p.isPresent()) {
			PreRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Predmet_Entity> getAllPredmeteByID(ArrayList<Integer> ids) {
		ArrayList<Predmet_Entity> predmeti = new ArrayList<>();

		for (int predmetID : ids) {
			Optional<Predmet_Entity> indbPredmeti = PreRepo.findById(predmetID);
			if (indbPredmeti.isPresent()) {
				predmeti.add(indbPredmeti.get());
			} else {
				return null;
			}
		}
		return predmeti;
	}

}
