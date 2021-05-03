package com.autopecasriobranco.lojavirtualintegrada.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.autopecasriobranco.lojavirtualintegrada.entities.enums.TipoMov;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MVE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipomov", discriminatorType = DiscriminatorType.STRING)
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COD_MOVIMENTO", sequenceName = "COD_MOVIMENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COD_MOVIMENTO")
	private Long movimento;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;

	@Column(name="tipomov", insertable = false, updatable = false)
	protected String tipomov;

	@OneToMany(mappedBy = "id.movimento")
	private Set<PedidoItem> itens = new HashSet<>();

	public Movimento() {
	}

	public Movimento(Long movimento, Instant data, TipoMov tipoMov) {
		super();
		this.movimento = movimento;
		this.data = data;
		this.setTipoMov(tipoMov);
	}

	public Long getMovimento() {
		return movimento;
	}

	public void setMovimento(Long movimento) {
		this.movimento = movimento;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public TipoMov getTipoMov() {
		return TipoMov.valueOf(tipomov);
	}

	public void setTipoMov(TipoMov tipoMov) {
		if (tipoMov != null) {
			this.tipomov = tipoMov.getCode();
		}
	}

	public Set<PedidoItem> getItens() {
		return itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movimento == null) ? 0 : movimento.hashCode());
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
		Movimento other = (Movimento) obj;
		if (movimento == null) {
			if (other.movimento != null)
				return false;
		} else if (!movimento.equals(other.movimento))
			return false;
		return true;
	}
}
