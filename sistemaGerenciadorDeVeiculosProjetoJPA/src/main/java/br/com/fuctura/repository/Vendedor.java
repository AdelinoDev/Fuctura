package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entities.Veiculo;
import jakarta.persistence.EntityManager;

public class Vendedor {
	
	public Veiculo salvar(Veiculo veiculo) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(veiculo);
			em.getTransaction().commit();
			
			return veiculo;
			
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
	
	
	public void deletar(Vendedor vendedor) {
	
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			Vendedor v = em.find(Vendedor.class, vendedor);
			
			if(v != null) {
				em.getTransaction().begin();
				em.remove(vendedor);
				em.getTransaction().commit();
			}
			
		} finally {
			em.close();
		}
		
	}

	
}
