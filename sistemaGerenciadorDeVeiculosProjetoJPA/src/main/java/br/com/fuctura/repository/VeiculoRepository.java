package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class VeiculoRepository {
	
	/*
	private EntityManagerFactory emf;
    private EntityManager em;

    public VeiculoRepository() {
        this.emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
        this.em = emf.createEntityManager();
    }
    */
	
	private EntityManagerFactory emf;
    private EntityManager em;

    public VeiculoRepository() {
        this.emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
        this.em = emf.createEntityManager();
    }
	
	//Insrir dados veiculo
	public void salvarVeiculo(Veiculo veiculo) {
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
	}
	
	//Listar todos veiculos
	public List<Veiculo> listarTodos() {
		return em.createQuery("FROM Veiculo", Veiculo.class).getResultList();
	}
	
	//Buscar por id
	public Veiculo buscarPorId(Integer codigo) {
		return em.find(Veiculo.class, codigo);
	}
	
	//Atualizar
	public void atualizar(Veiculo veiculo) {
		em.getTransaction().begin();
		em.merge(veiculo);
		em.getTransaction().commit();
	}
	
	//Deletar veiculo
	public void deletarVeiculo(Integer codigo) {
		
		Veiculo v = buscarPorId(codigo);
		
		if(v != null) {
			em.getTransaction().begin();
			em.remove(v);
			em.getTransaction().commit();
		}
	}
	
	// Fechar o EntityManager e o EntityManagerFactory
    public void fechar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
