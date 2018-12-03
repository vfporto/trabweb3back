package DAO;

import java.util.List;

import javax.persistence.Query;

import model.IngredienteModel;

@SuppressWarnings("rawtypes")
public class IngredienteDAO extends DAO {
	
	@SuppressWarnings("unchecked")
	public List<IngredienteModel> listPaginado(int pagina, int limitePorPagina){
		manager.clear(); //limpeza de cache de queries
		Query query = manager.createQuery("Select i from IngredienteModel i");
		query.setMaxResults(limitePorPagina);
		query.setFirstResult(pagina*limitePorPagina-limitePorPagina);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<IngredienteModel> listaTudoOrdenado(){
		manager.clear(); //limpeza de cache de queries
		return manager.createQuery("Select i from IngredienteModel i order by i.nome").getResultList();
	}

}
