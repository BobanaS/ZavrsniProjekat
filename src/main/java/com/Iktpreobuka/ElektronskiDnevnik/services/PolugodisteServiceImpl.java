package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Polugodiste_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Polugodiste_Repository;
@Service
public class PolugodisteServiceImpl implements PolugodisteService {
@Autowired
private Polugodiste_Repository PoluRepo;
	@Override
	public List<Polugodiste_Entity> getAllPolugodiste() {
		List<Polugodiste_Entity> polugodiste = (List<Polugodiste_Entity>) PoluRepo.findAll();
		return polugodiste;
	}

	@Override
	public Polugodiste_Entity findPolugodisteById(int id) {
		Optional<Polugodiste_Entity> s = PoluRepo.findById(id);
		if (s.isPresent()) {
			return s.get();
		} else {
			return null;
		}
	}

	@Override
	public Polugodiste_Entity savePolugodiste(Polugodiste_Entity polugodiste) {
		int id = polugodiste.getSkolskagodina().getId_sg();

		ArrayList<Polugodiste_Entity> polugodista = PoluRepo.findBySkolskaGodinaId(id);
		if (polugodista.size()==2) {
			return null;
		} else if ((polugodista.size() == 0)
				|| ((polugodista.size() == 1) && (polugodista.get(0).getRbrp()!= polugodiste.getRbrp()))) {
			return PoluRepo.save(polugodiste);

		} else
			return null;

	}

	@Override
	public Polugodiste_Entity updatePolugodiste(Polugodiste_Entity polugodiste, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePolugodiste(int id) {
		Optional<Polugodiste_Entity> p = PoluRepo.findById(null);
		if (p.isPresent()) {
			PoluRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
