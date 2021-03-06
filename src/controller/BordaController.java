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

import DAO.BordaDAO;
import DAO.DAO;
import model.BordaIngredienteModel;
import model.BordaModel;

@Path("borda")
public class BordaController {
	BordaDAO dao = new BordaDAO();
	
	@GET 
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BordaModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<BordaModel> lista = dao.listPaginado(pagina,limitePorPagina);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BordaModel salvar(BordaModel borda) {
		dao.save(borda);
		return borda;
	}

	/*@POST
	@Path("inserirIngrediente")
	public void inserirIngrediente(@QueryParam("idBorda") long idBorda, @QueryParam("idIngrediente") long idIngrediente, @QueryParam("quantidade") double quantidade) {
		DAO<BordaIngredienteModel> daoBI = new DAO<>();
		BordaIngredienteModel bi = daoBI.findById(BordaIngredienteModel.class, id)
				
		
	}*/
	
	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(BordaModel borda) {
		dao.update(borda);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public BordaModel buscarPorId(@QueryParam("id") long id) {
		return (BordaModel) dao.findById(BordaModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		dao.delete(BordaModel.class, id);
	}
	
}
