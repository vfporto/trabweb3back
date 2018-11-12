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

import DAO.SaborPizzaDAO;
import model.SaborPizzaModel;
import util.Utilitarios;

@Path("saborPizza")
public class SaborPizzaController {
	SaborPizzaDAO dao = new SaborPizzaDAO();
	
	@GET 
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SaborPizzaModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<SaborPizzaModel> lista = dao.listPaginado(pagina,limitePorPagina);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(SaborPizzaModel saborPizza) {
		dao.save(saborPizza);
	}

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(SaborPizzaModel saborPizza, @QueryParam("nomeArquivoAnterior") String nomeArquivoAnterior) {
		if(nomeArquivoAnterior != null) {
			String caminho = "/uploads/"+nomeArquivoAnterior;
			String caminhoCompleto = new Utilitarios().getRaizServidor()+caminho;
			new Utilitarios().deletarArquivo(caminhoCompleto);
		}
		dao.update(saborPizza);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public SaborPizzaModel buscarPorId(@QueryParam("id") long id) {
		return (SaborPizzaModel) dao.findById(SaborPizzaModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		SaborPizzaModel saborPizza = (SaborPizzaModel) dao.findById(SaborPizzaModel.class, id);
		if(saborPizza.getFoto() != null) {
			String caminho = "/uploads/"+saborPizza.getFoto();
			String caminhoCompleto = new Utilitarios().getRaizServidor()+caminho;
			new Utilitarios().deletarArquivo(caminhoCompleto);
		}
		dao.delete(SaborPizzaModel.class, id);
	}


}
