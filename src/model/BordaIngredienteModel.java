package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import DAO.EntidadeBase;

//JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name="borda_ingrediente")
public class BordaIngredienteModel implements EntidadeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties("listaIngredientes")
	@ManyToOne
	@JoinColumn(name="borda_id", nullable=false)
	private BordaModel borda;
	
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id", nullable=false)
	@JsonBackReference
	private IngredienteModel ingrediente;
	
	@Column
	private double quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BordaModel getBorda() {
		return borda;
	}

	public void setBorda(BordaModel borda) {
		this.borda = borda;
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
