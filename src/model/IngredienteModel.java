package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name="ingrediente")
public class IngredienteModel implements EntidadeBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private double qtEstoque;
	
	@Column
	private double qtMinima;
	
	@Column
	private double qtMaxima;
	
	@Column
	private String unidadeMedida;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQtEstoque() {
		return qtEstoque;
	}

	public void setQtEstoque(double qtEstoque) {
		this.qtEstoque = qtEstoque;
	}

	public double getQtMinima() {
		return qtMinima;
	}

	public void setQtMinima(double qtMinima) {
		this.qtMinima = qtMinima;
	}

	public double getQtMaxima() {
		return qtMaxima;
	}

	public void setQtMaxima(double qtMaxima) {
		this.qtMaxima = qtMaxima;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	
	
	
	

}
