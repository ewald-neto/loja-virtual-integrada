package com.autopecasriobranco.lojavirtualintegrada.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EST")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator( name = "ID_PRODUTO", sequenceName = "ID_PRODUTO", allocationSize = 1 ) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUTO")
	private String produto;
    private String referencia;
    private String nome;
    private Integer qtdatual;
    private Double custo;
    private Double preco;
    private Double margem;
    private String aplicacoes;

	@ManyToOne
	@JoinColumn(name = "grupo")
	private Grupo grupo;
    
	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItem> itens = new HashSet<>();
	
	public Produto() {
    }

	public Produto(String produto, String referencia, String nome, Integer qtdatual, Double custo, Double preco,
			Double margem, String aplicacoes) {
		super();
		this.produto = produto;
		this.referencia = referencia;
		this.nome = nome;
		this.qtdatual = qtdatual;
		this.custo = custo;
		this.preco = preco;
		this.margem = margem;
		this.aplicacoes = aplicacoes;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdatual() {
		return qtdatual;
	}

	public void setQtdatual(Integer qtdatual) {
		this.qtdatual = qtdatual;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getMargem() {
		return margem;
	}

	public void setMargem(Double margem) {
		this.margem = margem;
	}

	public String getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(String aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@JsonIgnore
	public Set<Movimento> getMovimentos() {
		Set<Movimento> set = new HashSet<>();
		for (PedidoItem x : itens) {
			set.add(x.getMovimento());
		}
		return set;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
}
