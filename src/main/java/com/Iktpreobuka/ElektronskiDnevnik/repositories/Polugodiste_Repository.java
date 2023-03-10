package com.Iktpreobuka.ElektronskiDnevnik.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.Iktpreobuka.ElektronskiDnevnik.entities.Polugodiste_Entity;

public interface Polugodiste_Repository extends CrudRepository<Polugodiste_Entity, Integer> {
	ArrayList<Polugodiste_Entity> findBySkolskaGodinaId(int id);
}
