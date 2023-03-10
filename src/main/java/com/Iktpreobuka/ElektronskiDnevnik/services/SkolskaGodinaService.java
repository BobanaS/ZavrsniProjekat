package com.Iktpreobuka.ElektronskiDnevnik.services;

import java.util.List;

import com.Iktpreobuka.ElektronskiDnevnik.entities.SkolskaGodina_Entity;

public interface SkolskaGodinaService {
public List<SkolskaGodina_Entity> getAllGodine();
	
	public  SkolskaGodina_Entity findGodinaById(int id) ;
	
	public SkolskaGodina_Entity saveGodina(SkolskaGodina_Entity godina);
	
	public SkolskaGodina_Entity updateSkolskaGodina(SkolskaGodina_Entity godina, int id);
	
	public boolean removeSkolskaGodina(int id);

}
