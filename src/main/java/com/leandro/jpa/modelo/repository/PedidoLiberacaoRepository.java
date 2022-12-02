package com.leandro.jpa.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.jpa.modelo.entidade.PedidoLiberacao;

@Repository
public interface PedidoLiberacaoRepository extends CrudRepository<PedidoLiberacao, Long>{

	
}
