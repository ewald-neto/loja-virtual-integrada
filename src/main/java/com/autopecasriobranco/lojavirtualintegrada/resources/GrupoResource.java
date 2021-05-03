package com.autopecasriobranco.lojavirtualintegrada.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.autopecasriobranco.lojavirtualintegrada.entities.Grupo;
import com.autopecasriobranco.lojavirtualintegrada.services.GrupoService;

@RestController
@RequestMapping(value="/grupos")
public class GrupoResource {
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping
	public ResponseEntity<List<Grupo>> findAll() {
		List<Grupo> list = grupoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Grupo> findById(@PathVariable Long id) {
		Grupo grupo = grupoService.findById(id);
		return ResponseEntity.ok().body(grupo);
	}
	
	@PostMapping
	public ResponseEntity<Grupo> insert(@RequestBody Grupo obj) {
		obj = grupoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getGrupo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		grupoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Grupo> update(@PathVariable Long id, @RequestBody Grupo obj) {
		obj = grupoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
