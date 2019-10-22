package br.com.douglas.financas.teste;

import javax.persistence.EntityManager;

import br.com.douglas.financas.modelo.Cliente;
import br.com.douglas.financas.modelo.Conta;
import br.com.douglas.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(2);
	
		Cliente cli = new Cliente();
		cli.setNome("Douglas");
		cli.setEndereco("Rua Osmário, 346");
		cli.setProfissao("Programador");
		cli.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cli);
		
		em.getTransaction().commit();
		em.close();
	}
}
