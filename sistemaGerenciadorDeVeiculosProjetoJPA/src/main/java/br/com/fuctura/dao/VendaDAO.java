package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Venda;
import jakarta.persistence.EntityManager;

public class VendaDAO {

	public Venda salvarVenda(Venda venda) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(venda);
			em.getTransaction().commit();

			return venda;

		} finally {
			em.close();
		}
	}

	
	public List<Venda> listarTodos() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.createQuery("FROM venda", Venda.class).getResultList();
			
		} finally {
			em.close();
		}
		
	}
	
	
	public Venda buscarPorId(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.find(Venda.class, codigo);
		} finally {
			em.close();
		}
		
	}


	public Venda atualizar(Venda venda) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(venda);
			em.getTransaction().commit();
			
			return venda;
		} finally {
			em.close();
		}
	}


	public void deletar(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			Venda v = em.find(Venda.class, codigo);
			
			if(v != null) {
				em.getTransaction().begin();
				em.remove(codigo);
				em.getTransaction().commit();
			}
			
		} finally {
			em.close();
		}	
	}
	
	
	
}
