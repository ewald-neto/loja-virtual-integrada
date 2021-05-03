package com.autopecasriobranco.lojavirtualintegrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autopecasriobranco.lojavirtualintegrada.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
