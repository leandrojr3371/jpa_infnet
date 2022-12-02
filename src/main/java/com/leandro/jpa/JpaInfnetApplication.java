package com.leandro.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leandro.jpa.core.Pessoa;
import com.leandro.jpa.modelo.entidade.Cliente;
import com.leandro.jpa.modelo.entidade.Execucao;
import com.leandro.jpa.modelo.entidade.ExecucaoFinanceira;
import com.leandro.jpa.modelo.entidade.PedidoLiberacao;
import com.leandro.jpa.modelo.entidade.PedidoLiberacaoMembro;
import com.leandro.jpa.modelo.repository.ClienteRepository;
import com.leandro.jpa.modelo.repository.ExecucaoRepository;
import com.leandro.jpa.modelo.repository.PedidoLiberacaoRepository;

@SpringBootApplication
public class JpaInfnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaInfnetApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runCliente(ClienteRepository clienteRepository, 
			PedidoLiberacaoRepository pedidoLiberacaoRepository,
			ExecucaoRepository execucaoRepository) {
		return (args) -> {
			//Salva clientes pessoa fisica e juridica
			Cliente clienteFisico = new Cliente("Leandro", "Rua123", Pessoa.FISICA);
			Cliente clienteJuridico = new Cliente("Leandro", "Rua123", Pessoa.JURIDICA);
			clienteRepository.save(clienteFisico);
			clienteRepository.save(clienteJuridico);
			
			List<PedidoLiberacaoMembro> listaMembrosFisico = new ArrayList<>();
			List<PedidoLiberacaoMembro> listaMembrosJuridico = new ArrayList<>();
			
			PedidoLiberacaoMembro pedidoMembroFisico = new PedidoLiberacaoMembro("7513215.0001", 200, 300);
			listaMembrosFisico.add(pedidoMembroFisico);
			pedidoMembroFisico = new PedidoLiberacaoMembro("7513215.0002", 500, 600);
			listaMembrosFisico.add(pedidoMembroFisico);			
			
			PedidoLiberacaoMembro pedidoMembroJuridico = new PedidoLiberacaoMembro("7513215.0001", 500, 1000);
			listaMembrosJuridico.add(pedidoMembroJuridico);
			pedidoMembroJuridico = new PedidoLiberacaoMembro("7513215.0002", 500, 10000);
			listaMembrosJuridico.add(pedidoMembroJuridico);		
			
			//Salva pedido de liberação e membros em cascata de um cliente fisico e juridico
			PedidoLiberacao pedidoClienteFisico = new PedidoLiberacao(100, "OPERACAO 000.1",clienteFisico, listaMembrosFisico);
			pedidoLiberacaoRepository.save(pedidoClienteFisico);
			PedidoLiberacao pedidoClienteJuridica= new PedidoLiberacao(100, "OPERACAO 000.2",clienteJuridico, listaMembrosJuridico);			
			pedidoLiberacaoRepository.save(pedidoClienteJuridica);
			
			//Listar todos clientes
			List<Cliente> listaClientes = (List<Cliente>) clienteRepository.findAll();
			System.out.println(listaClientes);
			
			//Listar apenas clientes Pessoa Fisica
			List<Cliente> listaClientesJuridica = (List<Cliente>) clienteRepository.findByPessoa(Pessoa.JURIDICA);
			System.out.println(listaClientesJuridica);
			
			//Listar todos pedidos
			List<PedidoLiberacao> listaPedidos = (List<PedidoLiberacao>) pedidoLiberacaoRepository.findAll();
			System.out.println(listaPedidos);
			
			//Remove um pedido com efeito cascata, removendo também seus pedidos membros
			pedidoLiberacaoRepository.deleteById(1L);
			
			//Depois de excluir o pedido ligado a cliente 1, consigo remover ele.
			clienteRepository.deleteById(1L);
			
			//Salvar execucao com herança
			ExecucaoFinanceira execFin = new ExecucaoFinanceira(true, "Intervenção 0001");
			execucaoRepository.save(execFin);
			
			//Lista execucao
			List<Execucao> listaExec = (List<Execucao>) execucaoRepository.findAll();
			System.out.println(listaExec);
		};
	}
	

}

