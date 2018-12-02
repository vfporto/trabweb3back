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

import DAO.TamanhoPizzaDAO;
import model.TamanhoPizzaModel;

@Path("tamanhoPizza")
public class TamanhoPizzaController {

	private TamanhoPizzaDAO dao = new TamanhoPizzaDAO();
	
	@GET 
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TamanhoPizzaModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<TamanhoPizzaModel> lista = dao.listPaginado(pagina,limitePorPagina);
		return lista;
	}
	
	@GET 
	@Path("listarTudo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TamanhoPizzaModel> listarTudo() {
		List<TamanhoPizzaModel> lista = dao.listaAll(TamanhoPizzaModel.class);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(TamanhoPizzaModel tamanhoPizza) {
		dao.save(tamanhoPizza);
	}

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(TamanhoPizzaModel tamanhoPizza) {
		dao.update(tamanhoPizza);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public TamanhoPizzaModel buscarPorId(@QueryParam("id") long id) {
		return (TamanhoPizzaModel) dao.findById(TamanhoPizzaModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		dao.delete(TamanhoPizzaModel.class, id);
	}

}