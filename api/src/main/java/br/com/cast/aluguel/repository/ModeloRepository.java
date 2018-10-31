package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Modelo;

@Repository
public class ModeloRepository {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Modelo> buscarPorFabricante(Integer idFabricante) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT m FROM ")
		   .append(Modelo.class.getName()).append(" m ")
		   .append(" WHERE m.fabricante.id = :idFabricante ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("idFabricante", idFabricante);
		
		return query.getResultList();
	}
}
