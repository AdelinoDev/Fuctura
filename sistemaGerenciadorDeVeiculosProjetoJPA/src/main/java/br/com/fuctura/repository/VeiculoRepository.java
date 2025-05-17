package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entities.Veiculo;
import jakarta.persistence.EntityManager;

public class VeiculoRepository {
	
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
            return em.find(Veiculo.class, codigo);
            
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
