package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Ucenik_Repository;
@Service
public class UcenikServiceImpl implements UcenikService {
	@Autowired
	private Ucenik_Repository UceRepo;
	@Override
	public List<Ucenik_Entity> getAllStudents() {
		List<Ucenik_Entity> ucenici = (List<Ucenik_Entity>) UceRepo.findAll();
		return ucenici;
	}
	
	@Override
	public Ucenik_Entity findUcenikeById(int id) {
		Optional<Ucenik_Entity> u = UceRepo.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	@Override
	public Ucenik_Entity saveUcenik(Ucenik_Entity ucenik) {
		try {
			return UceRepo.save(ucenik);
		} catch (Exception e) {
			return null;
		}
	}
	

	@Override
	public Ucenik_Entity updateUcenik(Ucenik_Entity student, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUcenik(int id) {
		Optional<Ucenik_Entity> u = UceRepo.findById(id);
		if (u.isPresent()) {
			UceRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Ucenik_Entity> getAllUcenikeByID(ArrayList<Integer> ids) {
		ArrayList<Ucenik_Entity> ucenici = new ArrayList<>();

	for (int uceniciId : ids) {
		Optional<Ucenik_Entity> indbUcenik = UceRepo.findById(uceniciId);
		if (indbUcenik.isPresent()) {
			ucenici.add(indbUcenik.get());
		} else {
			return null;
		}
	}
	return ucenici;
}

}

