package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DAO.SaborPizzaIngredienteDAO;
import model.SaborPizzaIngredienteModel;

@Path("saborPizzaIngrediente")
public class SaborPizzaIngredienteController {
	SaborPizzaIngredienteDAO dao = new SaborPizzaIngredienteDAO();
	
	@GET 
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SaborPizzaIngredienteModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<SaborPizzaIngredienteModel> lista = dao.listPaginado(pagina,limitePorPagina);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(SaborPizzaIngredienteModel saborPizzaIngrediente) {
		dao.save(saborPizzaIngrediente);
	}
	
	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(SaborPizzaIngredienteModel saborPizzaIngrediente) {
		dao.update(saborPizzaIngrediente);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public SaborPizzaIngredienteModel buscarPorId(@QueryParam("id") long id) {
		return (SaborPizzaIngredienteModel) dao.findById(SaborPizzaIngredienteModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		dao.delete(SaborPizzaIngredienteModel.class, id);
	}
	
}
