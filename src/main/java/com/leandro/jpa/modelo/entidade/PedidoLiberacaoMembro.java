package com.leandro.jpa.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoLiberacaoMembro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PED_LIBR_MEMBR")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PED_LIBR")
	private PedidoLiberacao pedidoLiberacao;
	
	public PedidoLiberacaoMembro() {
		
	}
	
	public PedidoLiberacaoMembro(String subcredito, double valorSolicitado, double valorLiberado) {
		this.subcredito = subcredito;
		this.valorSolicitado = valorSolicitado;
		this.valorLiberado = valorLiberado;
	}
	private String subcredito;
	
	private double valorSolicitado;
	
	private double valorLiberado;
	
	public PedidoLiberacao getPedidoLiberacao() {
		return pedidoLiberacao;
	}

	public void setPedidoLiberacao(PedidoLiberacao pedidoLiberacao) {
		this.pedidoLiberacao = pedidoLiberacao;
	}

	public String getSubcredito() {
		return subcredito;
	}

	public void setSubcredito(String subcredito) {
		this.subcredito = subcredito;
	}

	public double getValorSolicitado() {
		return valorSolicitado;
	}

	public void setValorSolicitado(double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

	public double getValorLiberado() {
		return valorLiberado;
	}

	public void setValorLiberado(double valorLiberado) {
		this.valorLiberado = valorLiberado;
	}
}
