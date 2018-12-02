package DAO;

import java.util.List;

import javax.persistence.Query;

import model.TamanhoPizzaModel;

@SuppressWarnings("rawtypes")
public class TamanhoPizzaDAO extends DAO<TamanhoPizzaModel> {
	
	@SuppressWarnings("unchecked")
	public List<TamanhoPizzaModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select t from TamanhoPizzaModel t");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
