package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entities.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class VendedorRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
	EntityManager em = emf.createEntityManager();
	
	public void salvarVendedor(Vendedor vendedor) {
		
		em.getTransaction().begin();
		em.persist(vendedor);
		em.getTransaction().begin();
	}
	
	public void atualizarVendedor(Vendedor vendedor) {
		em.getTransaction().begin();
		em.merge(vendedor);
		em.getTransaction().commit();
	}
	
	public Vendedor buscarVendedorPorId(Integer codigo) {
		return em.find(Vendedor.class, codigo);
	}
	
	public void deletarVendedorPorId(Integer codigo) {
		 Vendedor v = buscarVendedorPorId(codigo);
		 
		 if(v != null) {
			 em.getTransaction().begin();
			 em.remove(v);
			 em.getTransaction().commit();
		 }
	}
	
	public List<Vendedor> listarTodosVendedores() {
		return em.createQuery("FROM Vendedor", Vendedor.class).getResultList();
	}
	
	
	public void fechar() {
		if(em != null && em.isOpen()) {
			em.close();
		}
		
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
	

}
