package br.com.fuctura.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Endereco {
	
	public Endereco salvar(Endereco endereco) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
			
			return endereco;
			
		} finally {
			em.close();
		}
	}

	
	public List<Endereco> listaTodos() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.createQuery("FROM endereco", Endereco.class).getResultList();
			
		} finally {
			em.close();
		}
		
	}


	public Endereco buscarPorId(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.find(Endereco.class, codigo);
			
		} finally {
			em.close();
		}
	}

	
	public Endereco atualizar(Endereco endereco) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction();
			em.merge(endereco);
			em.getTransaction().commit();
			
			return endereco;
			
		} finally {
			em.close();
		}
	}


	public void deletar(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			Endereco e = em.find(Endereco.class, codigo);
			
			if(e != null) {
				em.getTransaction().begin();
				em.remove(codigo);
				em.getTransaction().commit();
	
			}
			
		} finally {
			em.close();
		}
	}
}
