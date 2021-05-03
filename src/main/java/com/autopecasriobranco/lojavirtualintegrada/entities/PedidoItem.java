package com.autopecasriobranco.lojavirtualintegrada.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.autopecasriobranco.lojavirtualintegrada.entities.pk.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "IME")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();
	
	@SequenceGenerator( name = "COD_ITEMMOVIMENTO", sequenceName = "COD_ITEMMOVIMENTO", allocationSize = 1 ) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COD_ITEMMOVIMENTO")
	private Long registro;
	private Integer qtd;
	private Double valor;
	private Double custo;
	private Double total;

	public PedidoItem() {
	}

	public PedidoItem(Movimento movimento, Produto produto, Long registro, Integer qtd, Double valor, Double custo, Double total) {
		super();
		id.setMovimento(movimento);
		id.setProduto(produto);
		this.qtd = qtd;
		this.valor = valor;
		this.custo = custo;
		this.total = total;
	}

	@JsonIgnore
	public Movimento getMovimento() {
		return id.getMovimento();
	}
	
	public void setMovimento(Movimento movimento) {
		id.setMovimento(movimento);
	}
	
	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
