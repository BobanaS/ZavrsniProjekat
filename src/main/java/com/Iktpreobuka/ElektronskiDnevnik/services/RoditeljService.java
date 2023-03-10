package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Roditelj_Entity;

public interface RoditeljService {
public List<Roditelj_Entity> getAllRoditelje();
	
	public Roditelj_Entity findRoditeljById(int id);
	
	public Roditelj_Entity saveRoditelj(Roditelj_Entity roditelj);
	
	
	public Boolean removeRoditelj (int id);
}
