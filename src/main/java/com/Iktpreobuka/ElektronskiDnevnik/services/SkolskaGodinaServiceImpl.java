package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.SkolskaGodina_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.SkolskaGodina_Repository;
@Service
public class SkolskaGodinaServiceImpl implements SkolskaGodinaService {

	@Autowired
	private SkolskaGodina_Repository SkolskaRepo;
	@Override
	public List<SkolskaGodina_Entity> getAllGodine() {
			List<SkolskaGodina_Entity> godina = (List<SkolskaGodina_Entity>) SkolskaRepo.findAll();
			return godina;
	}

	@Override
	public SkolskaGodina_Entity findGodinaById(int id) {
		Optional<SkolskaGodina_Entity> sk = SkolskaRepo.findById(id);
		if (sk.isPresent()) {
			return sk.get();
		} else {
			return null;
		}
	}

	@Override
	public SkolskaGodina_Entity saveGodina(SkolskaGodina_Entity godina) {
		try {
			return SkolskaRepo.save(godina);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public SkolskaGodina_Entity updateSkolskaGodina(SkolskaGodina_Entity godina, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeSkolskaGodina(int id) {
		Optional<SkolskaGodina_Entity> sk = SkolskaRepo.findById(id);
		if (sk.isPresent()) {
			SkolskaRepo.deleteById(id);
			return true;
		}
		return false;
	}
	

	
	
}
