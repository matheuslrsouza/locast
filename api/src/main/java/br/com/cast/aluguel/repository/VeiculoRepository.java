package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Veiculo;

@Repository
public class VeiculoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Veiculo v) {
		em.persist(v);
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> buscarTodos() {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT v FROM ")
		   .append(Veiculo.class.getName()).append(" v ")
		   .append(" INNER JOIN FETCH v.modelo m ")
		   .append(" INNER JOIN FETCH m.fabricante ");
		
		Query query = em.createQuery(hql.toString());
		
		return query.getResultList();
	}

	public Veiculo buscarPorPlaca(String placa) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT v FROM ")
		   .append(Veiculo.class.getName()).append(" v ")
		   .append(" WHERE v.placa = :placa ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("placa", placa.toUpperCase().trim());
		
		try {
			return (Veiculo) query.getSingleResult();
		} catch(Exception e) {
			return null;
		}
	}
}
