package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class VeiculoDAO {
	
	public void salvarVeiculo(Veiculo veiculo) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(veiculo);
            em.getTransaction().commit();
            
            
        } finally {
            em.close();
        }
    }

	
    public List<Veiculo> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            return em.createQuery("FROM Veiculo", Veiculo.class).getResultList();
            
        } finally {
            em.close();
        }
    }

    
    public Veiculo buscarPorId(Integer codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            return em.createQuery("SELECT v FROM Veiculo v WHERE v.codigo = :codigo", Veiculo.class)
                     .setParameter("codigo", codigo)
                     .getSingleResult();
              
        } catch (NoResultException e) {
            return null; 
        } finally {
            em.close();
        }
    }

       
    public void atualizar(Veiculo veiculo) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(veiculo);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }

    
    public void deletarVeiculo(Integer codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Veiculo v = em.find(Veiculo.class, codigo);
            if (v != null) {
                em.getTransaction().begin();
                em.remove(v);
                em.getTransaction().commit();
                
            }
        } finally {
            em.close();
        }
    }

}
