package DAO;

import java.util.List;

import javax.persistence.Query;

import model.SaborPizzaModel;

@SuppressWarnings("rawtypes")
public class SaborPizzaDAO extends DAO {
	
	
	@SuppressWarnings("unchecked")
	public List<SaborPizzaModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select s from SaborPizzaModel s");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
