package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Fabricante;

@Repository
public class FabricanteRepository {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		Query query = em.createQuery("FROM " + Fabricante.class.getName());
		return query.getResultList();
	}
}
