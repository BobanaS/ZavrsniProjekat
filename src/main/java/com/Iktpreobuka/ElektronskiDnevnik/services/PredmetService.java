package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Predmet_Entity;

public interface PredmetService {
public List<Predmet_Entity> getAllPredmete();
	
	public Predmet_Entity findPredmeteById(int id);
	
	public Predmet_Entity savePredmete(Predmet_Entity PredmetEntity);
	
	public Predmet_Entity editPredmete(Predmet_Entity predmet, int id);
	
	public boolean removePredmete(int id);
	
	public ArrayList<Predmet_Entity> getAllPredmeteByID(ArrayList<Integer> ids);
	
}
