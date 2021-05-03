package com.autopecasriobranco.lojavirtualintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autopecasriobranco.lojavirtualintegrada.entities.MovimentoCliente;
import com.autopecasriobranco.lojavirtualintegrada.repositories.MovimentoClienteRepository;

@Service
public class MovimentoClienteService {
	
	@Autowired
	private MovimentoClienteRepository movimentoClienteRepository;
	
	public List<MovimentoCliente> findAll() {
		return movimentoClienteRepository.findAll();
	}
	
	public MovimentoCliente findById(Long id) {
		Optional<MovimentoCliente> movimento = movimentoClienteRepository.findById(id);
		return movimento.get();
	}

}
