package br.com.douglas.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.douglas.financas.modelo.Conta;
import br.com.douglas.financas.modelo.Movimentacao;
import br.com.douglas.financas.modelo.TipoMovimentacao;
import br.com.douglas.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
//		conta.setId(id); CASO QUEIRA ANEXAR EM UMA CONTA JA EXISTENTE
		conta.setAgencia("0102");
		conta.setBanco("Bradesco");
		conta.setNumero("1234");
		conta.setTitular("Leonardo");

		Movimentacao mov = new Movimentacao();
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Churrascaria");
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal("200.0"));
		mov.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(mov);
	
		
		em.getTransaction().commit();
		
		em.clear();

	}

}
