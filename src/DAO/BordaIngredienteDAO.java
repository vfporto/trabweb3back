package DAO;

import java.util.List;

import javax.persistence.Query;

import model.BordaIngredienteModel;
import model.BordaModel;

public class BordaIngredienteDAO extends DAO<BordaIngredienteModel>{
	
	public List<BordaIngredienteModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select b from BordaIngredienteModel b");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
