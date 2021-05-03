package com.autopecasriobranco.lojavirtualintegrada.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLI")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator( name = "COD_CLIENTE", sequenceName = "COD_CLIENTE", allocationSize = 1 ) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COD_CLIENTE")
	private Long cliente;
	private String  nome;
	private String  endereco;
	private String  bairro;
	private String  cidade;
	private String  uf;
	private String  cep;
	private String  cic;
	private String  insc_ident;
	private String  telefone;
	private String  email;
	private String  endereco_num;
	private String  endereco_cpl;
	private Integer  endereco_cod_mun;
	private Integer  endereco_cod_uf;
	private String  identidade;
	private String  inscricao_m;
	
	@OneToMany(mappedBy = "cliente")
	private List<MovimentoCliente> movimentos = new ArrayList<>();
	
	public Cliente() {
	}

	public Cliente(Long cliente, String nome, String endereco, String bairro, String cidade, String uf, String cep,
			String cic, String insc_ident, String telefone, String email, String endereco_num, String endereco_cpl,
			Integer endereco_cod_mun, Integer endereco_cod_uf, String identidade, String inscricao_m) {
		super();
		this.cliente = cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.cic = cic;
		this.insc_ident = insc_ident;
		this.telefone = telefone;
		this.email = email;
		this.endereco_num = endereco_num;
		this.endereco_cpl = endereco_cpl;
		this.endereco_cod_mun = endereco_cod_mun;
		this.endereco_cod_uf = endereco_cod_uf;
		this.identidade = identidade;
		this.inscricao_m = inscricao_m;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCic() {
		return cic;
	}

	public void setCic(String cic) {
		this.cic = cic;
	}

	public String getInsc_ident() {
		return insc_ident;
	}

	public void setInsc_ident(String insc_ident) {
		this.insc_ident = insc_ident;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco_num() {
		return endereco_num;
	}

	public void setEndereco_num(String endereco_num) {
		this.endereco_num = endereco_num;
	}

	public String getEndereco_cpl() {
		return endereco_cpl;
	}

	public void setEndereco_cpl(String endereco_cpl) {
		this.endereco_cpl = endereco_cpl;
	}

	public Integer getEndereco_cod_mun() {
		return endereco_cod_mun;
	}

	public void setEndereco_cod_mun(Integer endereco_cod_mun) {
		this.endereco_cod_mun = endereco_cod_mun;
	}

	public Integer getEndereco_cod_uf() {
		return endereco_cod_uf;
	}

	public void setEndereco_cod_uf(Integer endereco_cod_uf) {
		this.endereco_cod_uf = endereco_cod_uf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getInscricao_m() {
		return inscricao_m;
	}

	public void setInscricao_m(String inscricao_m) {
		this.inscricao_m = inscricao_m;
	}

	@JsonIgnore
	public List<MovimentoCliente> getMovimentos() {
		return movimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}
}
