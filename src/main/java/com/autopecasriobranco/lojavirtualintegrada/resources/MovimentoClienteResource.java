package com.autopecasriobranco.lojavirtualintegrada.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autopecasriobranco.lojavirtualintegrada.entities.MovimentoCliente;
import com.autopecasriobranco.lojavirtualintegrada.services.MovimentoClienteService;

@RestController
@RequestMapping(value="/mov_clientes")
public class MovimentoClienteResource {
	
	@Autowired
	private MovimentoClienteService movimentoClienteService;
	
	@GetMapping
	public ResponseEntity<List<MovimentoCliente>> findAll() {
		List<MovimentoCliente> list = movimentoClienteService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovimentoCliente> findById(@PathVariable Long id) {
		MovimentoCliente movimento = movimentoClienteService.findById(id);
		return ResponseEntity.ok().body(movimento);
	}
}
