package com.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MateriasDao;
import com.model.Materia;
import com.service.MateriaService;

@Service
@Transactional
public class MateriaServiceImpl implements MateriaService{
	private static final Logger logger = LoggerFactory.getLogger(MateriaServiceImpl.class);
	private Map<Long, Materia> db = new HashMap<>();
	private static long count = 1;
	
	@Autowired
	private MateriasDao dao;
	
	@Override
	public Collection<Materia> find() {
		return dao.find();
	}

	@Override
	public Materia load(Long id) {
		return dao.load(id);
	}

	@Override
	public Materia persist(Materia materia) {
		if(materia.getId() != null) {
			return merge(materia);
		}
		return dao.persist(materia);
	}

	@Override
	public Materia merge(Materia materia) {
		return dao.merge(materia);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

}
