package com.autopecasriobranco.lojavirtualintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autopecasriobranco.lojavirtualintegrada.entities.Cliente;
import com.autopecasriobranco.lojavirtualintegrada.repositories.ClienteRepository;
import com.autopecasriobranco.lojavirtualintegrada.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}
	
	public void delete(Long cliente) {
		clienteRepository.deleteById(cliente);
	}

	public Cliente update(Long cliente, Cliente obj) {
		Cliente entity = clienteRepository.getOne(cliente);
		updateData(entity, obj);
		return clienteRepository.save(entity);
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
	
}
