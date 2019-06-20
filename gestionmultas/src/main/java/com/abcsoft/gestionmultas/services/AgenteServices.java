package com.abcsoft.gestionmultas.services;

import java.util.List;

import com.abcsoft.gestionmultas.model.Agente;

public interface AgenteServices {

	
	public Agente create(Agente agente);
	
	public Agente read(Long codigo);
	public void delete(Long codigo);
	
	public List<Agente> getAll();
	
}
