package br.com.fuctura;

import java.util.Scanner;

import br.com.fuctura.entities.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("Nome: " + v1.getNome());
		
		
	
	}

}
