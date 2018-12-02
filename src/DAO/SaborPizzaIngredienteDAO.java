package DAO;

import java.util.List;

import javax.persistence.Query;

import model.SaborPizzaIngredienteModel;

public class SaborPizzaIngredienteDAO extends DAO<SaborPizzaIngredienteModel>{
	
	public List<SaborPizzaIngredienteModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select s from SaborPizzaIngredienteModel s");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}

}
