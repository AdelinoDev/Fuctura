package br.com.fuctura;

import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.repository.VeiculoRepository;
import br.com.fuctura.service.VeiculoService;
import br.com.fuctura.views.MenuVeiculo;

public class Aplicacao {

	public static void main(String[] args) {
		

		 MenuVeiculo mv = new MenuVeiculo();
		 
		 mv.MenuVeiculo();
    }
        
		
	

}

/*Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("h2-in-memory-pu");
		EntityManager em = emf.createEntityManager();
		
		Vendedor v = new Vendedor();
	
		v.setNome("Joao2");
		//v.setIdade(90);
		
		//CADASTRAR, INSERIR
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		
		//CONSULTAR
		Vendedor v1 = em.find(Vendedor.class, 1);
		
		System.out.println("Nome: " + v1.getNome());*/