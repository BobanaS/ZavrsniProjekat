package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.ArrayList;
import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Razred_Entity;
import com.Iktpreobuka.ElektronskiDnevnik.entities.Ucenik_Entity;

public interface RazredService {
public List<Razred_Entity> getAllRazrede();
	
	public Razred_Entity findRazredById(int id);
	
	public Razred_Entity saveRazred (Razred_Entity razred);
	
	public Razred_Entity editRazred(Razred_Entity razred, int id, ArrayList<Ucenik_Entity> ucenici);
	
	public boolean removeRazred (int id);
	
	public ArrayList<Razred_Entity> getAllRazredByID(ArrayList<Integer> ids);
}
