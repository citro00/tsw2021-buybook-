package it.unisa;

import java.sql.Date;

public class OrdiniBean {
// Variabili istanza
	private String stato; 
	private int id_ord; 
	private float costo;
	private float buono;
	private String cfcliente;
	private Date data;
	
	public float getBuono() {
		return buono;
	}
	public void setBuono(float buono) {
		this.buono = buono;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public int getId_ord() {
		return id_ord;
	}
	public void setId_ord(int id_ord) {
		this.id_ord = id_ord;
	}
	public String getCfcliente() {
		return cfcliente;
	}
	public void setCfcliente(String cfcliente) {
		this.cfcliente = cfcliente;
	}
	public Date getData() {
		return data;
	}public void setData(Date data) {
		this.data = data;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
}
