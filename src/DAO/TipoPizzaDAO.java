package DAO;

import java.util.List;

import javax.persistence.Query;

import model.TipoPizzaModel;

@SuppressWarnings("rawtypes")
public class TipoPizzaDAO extends DAO<TipoPizzaModel> {
	
	@SuppressWarnings("unchecked")
	public List<TipoPizzaModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select t from TipoPizzaModel t");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
