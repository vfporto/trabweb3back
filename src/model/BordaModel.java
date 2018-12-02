package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import DAO.EntidadeBase;

@Entity
@Table(name = "borda")
public class BordaModel implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String nome;

	@Column
	private double valorAdicional;

	public long getId() {
		return id;
	}

	@JsonIgnoreProperties("borda")
	@OneToMany(mappedBy = "borda", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<BordaIngredienteModel> listaIngredientes;

	
	
	public BordaModel() {
		super();
	}
	
	public BordaModel(long id) {
		super();
		this.id = id;
	}

	public BordaModel(long id, String nome, double valorAdicional, List<BordaIngredienteModel> listaIngredientes) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorAdicional = valorAdicional;
		this.listaIngredientes = listaIngredientes;
	}
	
	public BordaModel(String nome, double valorAdicional, List<BordaIngredienteModel> listaIngredientes) {
		super();
		this.nome = nome;
		this.valorAdicional = valorAdicional;
		this.listaIngredientes = listaIngredientes;
	}

	//Getters and Setters
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public List<BordaIngredienteModel> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<BordaIngredienteModel> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
