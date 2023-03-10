package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Roditelj_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Roditelj_Repository;
@Service
public class RoditeljServiceImpl implements RoditeljService {
	@Autowired
	private Roditelj_Repository RoditeljRepo;
	@Override
	public List<Roditelj_Entity> getAllRoditelje() {
			List<Roditelj_Entity> roditelji = (List<Roditelj_Entity>) RoditeljRepo.findAll();
			return roditelji;
	}

	@Override
	public Roditelj_Entity findRoditeljById(int id) {
		Optional<Roditelj_Entity> r = RoditeljRepo.findById(id);
		if (r.isPresent()) {
			return r.get();
		}else
		{
		return null;
	}
}

	@Override
	public Roditelj_Entity saveRoditelj(Roditelj_Entity roditelj) {
		try {
				return RoditeljRepo.save(roditelj);
			} catch (Exception e) {
				return null;
			}
		}
	

	@Override
	public Boolean removeRoditelj(int id) {
		Optional<Roditelj_Entity> r = RoditeljRepo.findById(id);
		if (r.isPresent()) {
			RoditeljRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
