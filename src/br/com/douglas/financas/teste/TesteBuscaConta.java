package br.com.douglas.financas.teste;

import javax.persistence.EntityManager;

import br.com.douglas.financas.modelo.Conta;
import br.com.douglas.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		//devolve um estado MANAGED da Conta o metodo find, dura até fechar o em
		//update com qualquer mudança na classe Conta
		Conta conta = em.find(Conta.class, 1); 
		
		//apenas MANAGED podem ser removidas do banco de dados.
//		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
		System.out.println(conta.getTitular());
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		
		em2.getTransaction().begin();
		//estado DETACHED ,não é anexada agora, mas ja foi
		//estava sob os cuidados de em, após o fechamento de em se tornou detached.
		conta.setTitular("Douglas");
		
		em2.merge(conta); //DETACHED --> MANAGED
		
		em2.getTransaction().commit();
		em2.close();
	}

}
