package com.autopecasriobranco.lojavirtualintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autopecasriobranco.lojavirtualintegrada.entities.Produto;
import com.autopecasriobranco.lojavirtualintegrada.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(String id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void delete(String produto) {
		produtoRepository.deleteById(produto);
	}

	public Produto update(String produto, Produto obj) {
		Produto entity = produtoRepository.getOne(produto);
		updateData(entity, obj);
		return produtoRepository.save(entity);
	}

	private void updateData(Produto entity, Produto obj) {
		entity.setReferencia(obj.getReferencia());
		entity.setNome(obj.getNome());
		entity.setQtdatual(obj.getQtdatual());
		entity.setCusto(obj.getCusto());
		entity.setPreco(obj.getPreco());
		entity.setMargem(obj.getMargem());
		entity.setAplicacoes(obj.getAplicacoes());
	}
}
