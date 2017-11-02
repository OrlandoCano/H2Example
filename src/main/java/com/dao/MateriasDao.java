package com.dao;

import java.util.Collection;

import com.model.Materia;

public interface MateriasDao {
	Collection<Materia> find();
	Materia load(Long id);
	Materia persist(Materia materia);
	Materia merge(Materia materia);
	void delete(Long id);
}
