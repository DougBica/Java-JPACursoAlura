package br.com.douglas.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.douglas.financas.modelo.Categoria;
import br.com.douglas.financas.modelo.Conta;
import br.com.douglas.financas.modelo.Movimentacao;
import br.com.douglas.financas.modelo.TipoMovimentacao;
import br.com.douglas.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {		
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negocios");
		
		
		Conta conta = new Conta();
		
		conta.setId(2);
		
		Movimentacao mov1 = new Movimentacao();
		
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Viagem SP");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal(150.0));
		
		mov1.setCategoria(Arrays.asList(cat1,cat2));
		mov1.setConta(conta);
		
		Movimentacao mov2 = new Movimentacao();
		
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Viagem RJ");
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setValor(new BigDecimal(300.0));
		
		mov2.setCategoria(Arrays.asList(cat1,cat2));
		mov2.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cat1);
		em.persist(cat2);
		
		em.persist(mov1);
		em.persist(mov2);
		
		em.getTransaction().commit();
		em.close();
	}
	


	
	
	

}
