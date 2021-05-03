package com.autopecasriobranco.lojavirtualintegrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autopecasriobranco.lojavirtualintegrada.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

}
