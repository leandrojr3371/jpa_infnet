package com.leandro.jpa.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EXEC")
public abstract class Execucao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exec")
	private Integer id;
	
	private String intervencao;
	
	private boolean impedeLiberacao;
	
	public Execucao() {
		
	}
	
	public Execucao(boolean impedeLiberacao, String intervencao) {
		this.impedeLiberacao = impedeLiberacao;
		this.intervencao = intervencao;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Execucao [id=" + id + ", intervencao=" + intervencao + ", impedeLiberacao=" + impedeLiberacao + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntervencao() {
		return intervencao;
	}

	public void setIntervencao(String intervencao) {
		this.intervencao = intervencao;
	}

	public boolean isImpedeLiberacao() {
		return impedeLiberacao;
	}

	public void setImpedeLiberacao(boolean impedeLiberacao) {
		this.impedeLiberacao = impedeLiberacao;
	}

	
	
}
