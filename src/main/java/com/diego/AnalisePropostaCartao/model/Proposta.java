package com.diego.AnalisePropostaCartao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe do objeto Proposta
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name="TAB_PROPOSTA")
public class Proposta {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public String data;
	public String statusProposta;
	public String statusSPC;
	public String statusDocumentos;
	//public String idUsuarioAnalista;
	@ManyToOne
	@JoinColumn
	public Cliente cliente;
	@ManyToOne
	@JoinColumn
	public Usuario usuario;

	public Proposta() {
	}

	public Proposta(long id, String data, String statusProposta, String statusSPC, String statusDocumentos,
			Cliente cliente, Usuario usuario) {
		super();
		this.id = id;
		this.data = data;
		this.statusProposta = statusProposta;
		this.statusSPC = statusSPC;
		this.statusDocumentos = statusDocumentos;
		this.cliente = cliente;
		this.usuario = usuario;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatusProposta() {
		return statusProposta;
	}

	public void setStatusProposta(String statusProposta) {
		this.statusProposta = statusProposta;
	}

	public String getStatusSPC() {
		return statusSPC;
	}

	public void setStatusSPC(String statusSPC) {
		this.statusSPC = statusSPC;
	}

	public String getStatusDocumentos() {
		return statusDocumentos;
	}

	public void setStatusDocumentos(String statusDocumentos) {
		this.statusDocumentos = statusDocumentos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
