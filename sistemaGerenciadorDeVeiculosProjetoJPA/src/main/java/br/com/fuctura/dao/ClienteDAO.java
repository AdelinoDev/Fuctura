package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entities.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAO {

    public Cliente salvar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
        } finally {
            em.close();
        }
    }

    public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorId(Integer codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, codigo);
        } finally {
            em.close();
        }
    }

    public Cliente atualizar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente atualizado = em.merge(cliente);
            em.getTransaction().commit();
            return atualizado;
        } finally {
            em.close();
        }
    }

    public void delete(Integer codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, codigo);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente); 
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}
