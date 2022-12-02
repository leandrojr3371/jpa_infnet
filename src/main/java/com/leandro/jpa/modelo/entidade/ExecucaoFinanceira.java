package com.leandro.jpa.modelo.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class ExecucaoFinanceira extends Execucao{
	
	private boolean pagamentoEfetuado;

	private String observacoesExecucaoFinanceira;
	
	public ExecucaoFinanceira() {
		
	}
	
	public ExecucaoFinanceira(boolean pagamentoEfetuado, String observacoesExecucaoFinanceira) {
		this.pagamentoEfetuado = pagamentoEfetuado;
		this.observacoesExecucaoFinanceira = observacoesExecucaoFinanceira;
		this.setImpedeLiberacao(false);
		this.setIntervencao("Teste Intervenção");
	}
	public boolean isPagamentoEfetuado() {
		return pagamentoEfetuado;
	}

	public void setPagamentoEfetuado(boolean pagamentoEfetuado) {
		this.pagamentoEfetuado = pagamentoEfetuado;
	}

	public String getObservacoesExecucaoFinanceira() {
		return observacoesExecucaoFinanceira;
	}

	public void setObservacoesExecucaoFinanceira(String observacoesExecucaoFinanceira) {
		this.observacoesExecucaoFinanceira = observacoesExecucaoFinanceira;
	}
}


