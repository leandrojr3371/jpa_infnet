package com.leandro.jpa.modelo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leandro.jpa.core.Pessoa;
import com.leandro.jpa.modelo.entidade.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	List<Cliente> findByPessoa(Pessoa pessoa);

}
