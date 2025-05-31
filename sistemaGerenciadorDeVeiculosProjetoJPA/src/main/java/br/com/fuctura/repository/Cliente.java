package br.com.fuctura.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Cliente {

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
			return em.createQuery("FROM cliente", Cliente.class).getResultList();

		} finally {
			em.close();
		}

	}

	public void buscarPorId(Integer codigo) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.find(Cliente.class, codigo);

		} finally {
			em.close();
		}

	}

	public Cliente atualizar(Cliente cliente) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();

			return cliente;

		} finally {
			em.close();

		}
	}

	public void delete(Integer codigo) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			Cliente c = em.find(Cliente.class, codigo);

			if (c != null) {
				em.getTransaction().begin();
				em.remove(codigo);
				em.getTransaction().commit();

			}

		} finally {
			em.close();
		}
	}
}
