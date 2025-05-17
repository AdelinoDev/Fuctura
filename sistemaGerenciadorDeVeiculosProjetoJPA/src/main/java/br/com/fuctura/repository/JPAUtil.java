package br.com.fuctura.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	 // Criado uma única vez, reutilizável durante toda a aplicação
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");

    
    // Gera um EntityManager novo a cada chamada
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void fecharFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
