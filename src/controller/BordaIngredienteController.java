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

import DAO.BordaIngredienteDAO;
import model.BordaIngredienteModel;

@Path("bordaIngrediente")
public class BordaIngredienteController {
	BordaIngredienteDAO dao = new BordaIngredienteDAO();
	
	@GET 
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BordaIngredienteModel> listar(@QueryParam("pagina") int pagina, @QueryParam("limitePorPagina") int limitePorPagina) {
		List<BordaIngredienteModel> lista = dao.listPaginado(pagina,limitePorPagina);
		return lista;
	}

	@POST
	@Path("salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(BordaIngredienteModel bordaIngrediente) {
		dao.save(bordaIngrediente);
	}

	/*@POST
	@Path("inserirIngrediente")
	public void inserirIngrediente(@QueryParam("idBordaIngrediente") long idBordaIngrediente, @QueryParam("idIngrediente") long idIngrediente, @QueryParam("quantidade") double quantidade) {
		DAO<BordaIngredienteIngredienteModel> daoBI = new DAO<>();
		BordaIngredienteIngredienteModel bi = daoBI.findById(BordaIngredienteIngredienteModel.class, id)
				
		
	}*/
	
	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterar(BordaIngredienteModel bordaIngrediente) {
		dao.update(bordaIngrediente);
	}

	@GET
	@Path("buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	public BordaIngredienteModel buscarPorId(@QueryParam("id") long id) {
		return (BordaIngredienteModel) dao.findById(BordaIngredienteModel.class, id);
	}

	@DELETE
	@Path("deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarPorId(@QueryParam("id") long id) {
		dao.delete(BordaIngredienteModel.class, id);
	}
	
}
