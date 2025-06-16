package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Tipo;
import jakarta.persistence.EntityManager;

public class TipoDAO {
	
	public Tipo salvar(Tipo tipo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();
			
			return tipo;
			
		} finally {
			em.close();
		}
			
	}

	
	public List<Tipo> buscarTodos() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.createQuery("FROM tipo", Tipo.class).getResultList();
			
		} finally {
			em.close();
		}
	}


	public Tipo buscarPorId(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.find(Tipo.class, codigo);
			
		} finally {
			em.close();
		}
		
	}


	public Tipo atualizar(Tipo tipo) {
		
		 EntityManager em = JPAUtil.getEntityManager();
		 
		 try {
			 em.getTransaction().begin();
			 em.merge(tipo);
			 em.getTransaction().commit();
			 
			 return tipo;
			 
		 } finally {
			 em.close();
		 }
		 
	}


	public void deletar(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			Tipo t = em.find(Tipo.class, codigo);
			
			if(t != null) {
				em.getTransaction().begin();
				em.remove(t);
				em.getTransaction().commit();
				
			}
		
		} finally {
			em.close();
		}
	}



}

