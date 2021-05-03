package com.autopecasriobranco.lojavirtualintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autopecasriobranco.lojavirtualintegrada.entities.Grupo;
import com.autopecasriobranco.lojavirtualintegrada.repositories.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}
	
	public Grupo findById(Long id) {
		Optional<Grupo> cliente = grupoRepository.findById(id);
		return cliente.get();
	}

	public Grupo insert(Grupo obj) {
		return grupoRepository.save(obj);
	}
	
	public void delete(Long grupo) {
		grupoRepository.deleteById(grupo);
	}

	public Grupo update(Long grupo, Grupo obj) {
		Grupo entity = grupoRepository.getOne(grupo);
		updateData(entity, obj);
		return grupoRepository.save(entity);
	}

	private void updateData(Grupo entity, Grupo obj) {
		entity.setNome(obj.getNome());
	}
	
}
