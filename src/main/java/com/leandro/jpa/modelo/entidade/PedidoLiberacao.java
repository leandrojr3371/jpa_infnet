package com.leandro.jpa.modelo.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_ped_libr")
public class PedidoLiberacao{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PED_LIBR")
	private Long id;
	
	private double valorTotal;
	
	private String operacao;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PED_LIBR")
	private List<PedidoLiberacaoMembro> membros = new ArrayList<>();
	
	public PedidoLiberacao() {
		
	}
	
	public PedidoLiberacao(double valorTotal, String operacao, Cliente cliente, List<PedidoLiberacaoMembro> membros) {
		this.valorTotal = valorTotal;
		this.operacao = operacao;
		this.cliente = cliente;
		this.membros = membros;
	}
	
	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "PedidoLiberacao [id=" + id + ", valorTotal=" + valorTotal + ", operacao=" + operacao + ", cliente="
				+ cliente + ", membros=" + membros + "]";
	}
}

