package com.Iktpreobuka.ElektronskiDnevnik.services;
import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Ocena_Entity;


public interface OcenaService {
public List<Ocena_Entity> getAllOcene();
	
	public Ocena_Entity findOcenuById(int id);

	public Ocena_Entity saveOcenu(Ocena_Entity ocena);
	
	public Ocena_Entity editOcena(Ocena_Entity ocena, int id);
	
	public boolean deleteOcena(int id);

}

