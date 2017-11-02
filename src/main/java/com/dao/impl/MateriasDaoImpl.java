package com.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dao.MateriasDao;
import com.model.Materia;

@Repository
public class MateriasDaoImpl implements MateriasDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Collection<Materia> find() {
		Query query = entityManager.createQuery("SELECT m FROM Materia m");
	    return (Collection<Materia>) query.getResultList();
	}

	@Override
	public Materia load(Long id) {
		return entityManager.find(Materia.class, id);
	}

	@Override
	public Materia persist(Materia materia) {
		entityManager.persist(materia);
		return materia;
	}

	@Override
	public Materia merge(Materia materia) {
		entityManager.merge(materia);
		return materia;
	}

	@Override
	public void delete(Long id) {
		Materia m = load(id);
		if(m != null) {
			entityManager.remove(m);
		}
	}

}
