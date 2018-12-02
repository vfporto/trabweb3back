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

import DAO.IngredienteDAO;
import model.IngredienteModel;
import model.TipoPizzaModel;

@Path("ingrediente")
public class IngredienteController {
	private IngredienteDAO dao = new IngredienteDAO();

	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IngredienteModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<IngredienteModel> lista = dao.listPaginado(pagina, limitePorPagina);
		return lista;
	}
	
	@GET
	@Path("listarTudo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IngredienteModel> listarTudo() {
		List<IngredienteModel> lista = dao.listaAll(IngredienteModel.class);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(IngredienteModel ingrediente) {
		dao.save(ingrediente);
	}

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(IngredienteModel ingrediente) {
		dao.update(ingrediente);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public IngredienteModel buscarPorId(@QueryParam("id") long id) {
		return (IngredienteModel) dao.findById(IngredienteModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		dao.delete(IngredienteModel.class, id);
	}

}
