package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name="tamanho")
public class TamanhoPizzaModel implements EntidadeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private int numMaximoSabores;
	
	@Column
	private double preco;
	
	@Column
	private double fatorMultiplicacao; //Qtas vezes essa pizza eh maior que a pequena (usada como referencia para calculo de ingredientes)
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumMaximoSabores() {
		return numMaximoSabores;
	}
	public void setNumMaximoSabores(int numMaximoSabores) {
		this.numMaximoSabores = numMaximoSabores;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getFatorMultiplicacao() {
		return fatorMultiplicacao;
	}
	public void setFatorMultiplicacao(double fatorMultiplicacao) {
		this.fatorMultiplicacao = fatorMultiplicacao;
	}
}
