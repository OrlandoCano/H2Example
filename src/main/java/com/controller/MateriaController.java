package com.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Materia;
import com.service.MateriaService;

@RestController
public class MateriaController {
	@Autowired
	private MateriaService service;
	
	@RequestMapping(value = "/materias", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Materia> loadMaterias(){
		return service.find();
	}
	
	@RequestMapping(value = "/materias/{id}", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Materia loadMateria(@PathVariable Long id){
		return service.load(id);
	}
	
	@RequestMapping(value = "/materias", method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Materia saveMateria(Materia materia){
		return service.persist(materia);
	}
	
	@RequestMapping(value = "/materias/{id}", method=RequestMethod.DELETE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteMateria(@PathVariable Long id, HttpServletResponse response){
		service.delete(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

}
