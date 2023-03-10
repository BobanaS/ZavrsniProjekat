package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Polugodiste_Entity;

public interface PolugodisteService {
public List<Polugodiste_Entity> getAllPolugodiste();
	
	public Polugodiste_Entity findPolugodisteById(int id);
	
	public Polugodiste_Entity savePolugodiste(Polugodiste_Entity polugodiste);
	
	public Polugodiste_Entity updatePolugodiste(Polugodiste_Entity polugodiste, int id);
	
	public boolean removePolugodiste(int id);
}
