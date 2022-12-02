package com.leandro.jpa.modelo.entidade;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class ExecucaoFisica extends Execucao{
	
	private Date dataExecucaoFisica;
	
	private String observacoesExecucaoFinanceira;
	
	public ExecucaoFisica() {
		
	}
	
	public ExecucaoFisica(Date dataExecucaoFisica, String observacoesExecucaoFinanceira) {
		this.dataExecucaoFisica = dataExecucaoFisica;
		this.observacoesExecucaoFinanceira = observacoesExecucaoFinanceira; 
	}
	
	public Date getDataExecucaoFisica() {
		return dataExecucaoFisica;
	}

	public void setDataExecucaoFisica(Date dataExecucaoFisica) {
		this.dataExecucaoFisica = dataExecucaoFisica;
	}

	public String getObservacoesExecucaoFinanceira() {
		return observacoesExecucaoFinanceira;
	}

	public void setObservacoesExecucaoFinanceira(String observacoesExecucaoFinanceira) {
		this.observacoesExecucaoFinanceira = observacoesExecucaoFinanceira;
	}
	
	
}
