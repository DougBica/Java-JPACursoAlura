package br.com.douglas.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.douglas.financas.modelo.Conta;
import br.com.douglas.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		
		//Estado TRANSIENT da classe Conta
		//se a aplicação cair a conta cai junto, sem ser inserida no banco
		
		conta.setTitular("José");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta); //TRANSIENT ---> MANAGED
		
		conta.setBanco("Bradesco");
		
		em.getTransaction().commit();
		
		em.close();

	}

}
