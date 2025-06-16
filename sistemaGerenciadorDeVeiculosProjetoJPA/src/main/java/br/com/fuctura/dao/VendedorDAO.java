package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Vendedor;
import jakarta.persistence.EntityManager;

public class VendedorDAO {
	
	public Vendedor salvar(Vendedor vendedor) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(vendedor);
			em.getTransaction().commit();
			
			return vendedor;
			
		} finally {
			em.close();
		}		
	}
	
	public List<Vendedor> listarTodos() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.createQuery("FROM vendedor", Vendedor.class).getResultList();
			
		} finally {
			em.close();
		}
		
	}
	
	
	public Vendedor buscarPorId(Integer codigo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			return em.find(Vendedor.class, codigo);
			
		} finally {
			em.close();
		}
		
	}
	
	public Vendedor atualizar(Vendedor vendedor) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(vendedor);
			em.getTransaction().commit();
			
			return vendedor;
			
		} finally {
			em.close();
		}
		
	}
	
	
	public void deletar(Integer codigo) {
	
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			Vendedor v = em.find(Vendedor.class, codigo);
			
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
