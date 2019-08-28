package com.diego.AnalisePropostaCartao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	public String idUsuarioAnalista;
	@ManyToOne
	@JoinColumn
	public Cliente cliente;
	
	
	
	public Proposta() {
	}

	public Proposta(String data, String statusProposta, String statusSPC, String statusDocumentos,
			String idUsuarioAnalista, Cliente cliente) {
		super();
		this.data = data;
		this.statusProposta = statusProposta;
		this.statusSPC = statusSPC;
		this.statusDocumentos = statusDocumentos;
		this.idUsuarioAnalista = idUsuarioAnalista;
		this.cliente = cliente;
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

	public String getIdUsuarioAnalista() {
		return idUsuarioAnalista;
	}

	public void setIdUsuarioAnalista(String idUsuarioAnalista) {
		this.idUsuarioAnalista = idUsuarioAnalista;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	

}
