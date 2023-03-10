package com.Iktpreobuka.ElektronskiDnevnik.services;
import java.util.ArrayList;
import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Nastavnik_Entity;

public interface NastavnikService {
	
public List<Nastavnik_Entity> getAllNastavnike();
	
	public Nastavnik_Entity findNastavnikById(int id);
	
	public Nastavnik_Entity saveNastavnik(Nastavnik_Entity nastavnik);
	
	public Nastavnik_Entity updateNastavnik(Nastavnik_Entity nastavnik, int id);
	
	public boolean removeNastavnik(int id);
	
	public ArrayList<Nastavnik_Entity> getAllNastavnikByID(ArrayList<Integer> id);

}
