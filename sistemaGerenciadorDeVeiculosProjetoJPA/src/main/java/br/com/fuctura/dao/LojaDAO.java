package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Loja;
import br.com.fuctura.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class LojaDAO {
	
	public void salvarLoja(Loja loja) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(loja);
            em.getTransaction().commit();
            
            
        } finally {
            em.close();
        }
    }

	
    public List<Loja> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            return em.createQuery("FROM Loja", Loja.class).getResultList();
            
        } finally {
            em.close();
        }
    }
    
    
    public Loja buscarPorId(Integer codigo) {
    	
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
    		return em.createQuery("SELECT l FROM l WHERE l.codigo = :codigo", Loja.class)
    				.setParameter("codigo", codigo)
    				.getSingleResult();
    		
    	} catch (NoResultException e) {
    		return null;
    		
    	} finally {
    		em.close();
    	}
    	  	
    }
    
    
    public Loja atualizar(Loja loja) {
    	
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
    		em.getTransaction().begin();
    		em.merge(loja);
    		em.getTransaction().commit();
    		
    		return loja;
    		
    	} finally {
    		em.close();
    	}
    }
    
    
    public void deletar(Integer codigo) {
    	
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
    		Loja l = em.find(Loja.class, codigo);
    		if(l != null) {
    			em.getTransaction().begin();
    			em.remove(l);
    			em.getTransaction().commit();
    		}
    		
    	} finally {
    		em.close();
    	}
    }
    

}
