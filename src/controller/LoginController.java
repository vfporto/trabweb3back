package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DAO.LoginDAO;
import model.FuncionarioModel;

@Path("login")
public class LoginController {
	private LoginDAO dao = new LoginDAO();
	
	@GET
	@Path("validar")
	@Produces(MediaType.APPLICATION_JSON)
	public FuncionarioModel validarLogin(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		return dao.findByLoginAndSenha(login, senha);
	}

}
