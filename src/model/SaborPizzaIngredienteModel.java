package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name="pizza_ingrediente")
public class SaborPizzaIngredienteModel implements EntidadeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="sabor_pizza_id", nullable=false)
	private SaborPizzaModel saborPizza;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id", nullable=false)
	private IngredienteModel ingrediente;
	
	@Column
	private double quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SaborPizzaModel getSaborPizza() {
		return saborPizza;
	}

	public void setSaborPizza(SaborPizzaModel saborPizza) {
		this.saborPizza = saborPizza;
	}

	public IngredienteModel getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteModel ingrediente) {
		this.ingrediente = ingrediente;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
