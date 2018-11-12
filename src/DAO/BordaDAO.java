package DAO;

import java.util.List;

import javax.persistence.Query;

import model.BordaModel;

@SuppressWarnings("rawtypes")
public class BordaDAO extends DAO {
	
	@SuppressWarnings("unchecked")
	public List<BordaModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select b from BordaModel b");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
