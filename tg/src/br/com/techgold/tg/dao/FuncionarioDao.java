package br.com.techgold.tg.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.techgold.tg.modelo.Funcionario;

public class FuncionarioDao {
	
	public boolean existe(Funcionario funcionario){
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Funcionario> query = em.createQuery("select f from Funcionario f where f.usuario = :pUsuario and f.senha = :pSenha",Funcionario.class);
		
		query.setParameter("pUsuario", funcionario.getUsuario());
		query.setParameter("pSenha", funcionario.getSenha());
		
		try {
			Funcionario result = query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		
		em.close();
		
		return true;
	}
	
}
