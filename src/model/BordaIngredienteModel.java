package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="borda_ingrediente")
public class BordaIngredienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="borda_id", nullable=false)
	private BordaModel borda;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id", nullable=false)
	private IngredienteModel ingrediente;

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
	
	
	

}
