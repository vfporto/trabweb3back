package DAO;

import javax.persistence.Query;

import model.FuncionarioModel;

@SuppressWarnings("rawtypes")
public class LoginDAO extends DAO {

	public FuncionarioModel findByLoginAndSenha(String login, String senha){
		Object retorno = null;
		try{
			manager.clear(); //limpeza de cache de queries
			Query query = manager.createQuery("Select c from FuncionarioModel c WHERE c.login = :login and c.senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			query.setMaxResults(1);
			retorno = query.getSingleResult();
			if(retorno != null)
				return (FuncionarioModel) retorno;
			else
				return null;

		}catch(Exception ex) {
			return null;
		}
	}

}
