package com.autopecasriobranco.lojavirtualintegrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autopecasriobranco.lojavirtualintegrada.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{

}
