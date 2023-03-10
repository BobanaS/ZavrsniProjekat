package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Email;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Nastavnik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Ocena_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Predmet_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Razred_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.repositories.Ocena_Repository;

@Service
public class OcenaServiceImpl implements OcenaService {
	@Autowired
	private Ocena_Repository OcenaRepo;

	@Autowired
	private EmailService emailService;

	
	
	
	
	
	@Override
	public List<Ocena_Entity> getAllOcene() {
		List<Ocena_Entity> ocene = (List<Ocena_Entity>) OcenaRepo.findAll();
		return ocene;
	}

	@Override
	public Ocena_Entity findOcenuById(int id) {
		Optional<Ocena_Entity> o = OcenaRepo.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Ocena_Entity saveOcenu(Ocena_Entity ocena) {
		Ucenik_Entity ucenik = ocena.getUcenik();
		Razred_Entity razred = ucenik.getRazred();
		List<Predmet_Entity> predmeti = razred.getPredmet();

		for (Predmet_Entity p : predmeti) {
			if (p.getId_P() == ocena.getPredmet().getId_P()) {

				List<Nastavnik_Entity> Nastavnici = p.getNastavnik();
				for (Nastavnik_Entity n : Nastavnici) {
					if (n.getId_n() == ocena.getNastavnik().getId_n()) {
						Ocena_Entity o = OcenaRepo.save(ocena);
						try {
							emailService.sendMessage(new Email(ucenik.getRoditelj().getEmail(),ucenik.getIme(), ucenik.getPrezime(),
									o.getOcena(), o.getTip_o(), o.getPredmet().getNaziv(), o.getNastavnik().getIme(), o.getNastavnik().getPrezime()));
						} catch (Exception e) {
							// do nothing
						}
						return o;
					}
				}
			}
		}
		return null;
	}
	

	@Override
	public Ocena_Entity editOcena(Ocena_Entity ocena, int id) {
		return null;
	}
	
	@Override
	public boolean deleteOcena(int id) {
		Optional<Ocena_Entity> o = OcenaRepo.findById(id);
		if (o.isPresent()) {
			OcenaRepo.deleteById(id);
			return true;
		}
		return false;
	}

	}

	
