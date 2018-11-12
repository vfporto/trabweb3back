package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name="sabor_pizza")
public class SaborPizzaModel implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="tipo_id", nullable=false)
	private TipoPizzaModel tipoPizza;
	
	@Column
	private String nome;
	
	@Column
	private double valorAdicional;
	
	@Column
	private String foto;
	
	@OneToMany(mappedBy = "saborPizza")
	private List<SaborPizzaIngredienteModel> listaIngredientes;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoPizzaModel getTipoPizza() {
		return tipoPizza;
	}

	public void setTipoPizza(TipoPizzaModel tipoPizza) {
		this.tipoPizza = tipoPizza;
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

	public List<SaborPizzaIngredienteModel> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<SaborPizzaIngredienteModel> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
