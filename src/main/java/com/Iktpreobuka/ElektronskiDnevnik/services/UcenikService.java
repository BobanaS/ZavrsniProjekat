package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;

public interface UcenikService {

	public List<Ucenik_Entity> getAllStudents();
	
	public Ucenik_Entity findUcenikeById (int id);
	
	public Ucenik_Entity saveUcenik(Ucenik_Entity student);

	public Ucenik_Entity updateUcenik(Ucenik_Entity student, int id);
	
	public boolean removeUcenik (int id);
	
	public ArrayList<Ucenik_Entity> getAllUcenikeByID(ArrayList<Integer> ids);
}

