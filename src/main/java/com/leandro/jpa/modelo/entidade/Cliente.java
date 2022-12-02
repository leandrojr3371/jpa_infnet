package com.leandro.jpa.modelo.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.leandro.jpa.core.Pessoa;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@OneToMany(mappedBy = "cliente")
	private List<PedidoLiberacao> pedidos;
	
	private String nome;
	
	private String endereco;
	
	private Pessoa pessoa;
	
	public Cliente() {
		
	}
	public Cliente(String nome, String endereco, Pessoa pessoa) {
		this.nome = nome;
		this.endereco = endereco;
		this.pessoa = pessoa;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", pessoa=" + pessoa.name() + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
