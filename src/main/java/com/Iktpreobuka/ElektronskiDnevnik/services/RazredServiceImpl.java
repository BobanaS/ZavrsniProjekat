package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Razred_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Razred_Repository;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Ucenik_Repository;
@Service
public class RazredServiceImpl implements RazredService {
	@Autowired
	private Razred_Repository RazRepo;
	
	@Autowired
	private Ucenik_Repository UcenikRepo;
	@Override
	public List<Razred_Entity> getAllRazrede() {
		List<Razred_Entity> razredi = (List<Razred_Entity>) RazRepo.findAll();
		return razredi;
	}

	@Override
	public Razred_Entity findRazredById(int id) {
		Optional<Razred_Entity> r = RazRepo.findById(id);
		if (r.isPresent()) {
			return r.get();
		} else {
			return null;
		}
	}


	@Override
	public Razred_Entity editRazred(Razred_Entity razred, int id, ArrayList<Ucenik_Entity> ucenici) {
		return razred;
		}


	@Override
	public boolean removeRazred(int id) {
		Optional<Razred_Entity> c = RazRepo.findById(id);
		if (c.isPresent()) {
			RazRepo.deleteById(id);
			return true;
		}
		return false;
	}
	

	@Override
	public ArrayList<Razred_Entity> getAllRazredByID(ArrayList<Integer> ids) {
			ArrayList<Razred_Entity> razredi = new ArrayList<>();

			for (Integer razId : ids) {
				Optional<Razred_Entity> indbClasses = RazRepo.findById(razId);
				if (indbClasses.isPresent()) {
					razredi.add(indbClasses.get());
				} else {
					return null;
				}
			}
			return razredi;
		}

	@Override
	public Razred_Entity saveRazred(Razred_Entity razred) {
		// TODO Auto-generated method stub
		return null;
	}

	}
