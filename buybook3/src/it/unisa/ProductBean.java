package it.unisa;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String codice;
	String nome;
	String genere;
	float prezzo;
	int quantità;
	int sconto;
	
	public ProductBean() {
		codice ="";
		nome = "";
		genere = "";
		quantità = 0;
		sconto=0;
		prezzo=0;  //controllare
	}

	public int getSconto() {
		return sconto;
	}
	
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String code) {
		this.codice = code;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getgenere() {
		return genere;
	}

	public void setgenere(String description) {
		this.genere = description;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrice(float f) {
		this.prezzo = f;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantity) {
		this.quantità = quantity;
	}

	@Override
	public String toString() {
		return nome + " (" + codice + "), " + prezzo + " " + quantità + ". " + genere+ " "+sconto;
	}

}
