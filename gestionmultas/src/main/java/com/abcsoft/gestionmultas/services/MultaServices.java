package com.abcsoft.gestionmultas.services;

import java.util.List;

import com.abcsoft.gestionmultas.model.Agente;
import com.abcsoft.gestionmultas.model.Multa;

public interface MultaServices {

	/**
	 * 
	 * Se crea una multa con un nuevo c�digo
	 * 
	 * @param multa
	 * @return
	 */
	public Multa create(Multa multa);
	
	public Multa read(Long codigo);
	
	public void delete(Long codigo);
	
	public List<Multa> getAll();
	public List<Multa> getByAgente(Agente agente);
	
	
}
