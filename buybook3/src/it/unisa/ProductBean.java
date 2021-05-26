package it.unisa;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String codice;
	String nome;
	String autore;
	String genere;
	float prezzo;
	int quantità;
	int sconto;
	
	public ProductBean() {
		codice ="";
		nome = "";
		autore="";
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
public String getAutore() {
	return autore;
}

public void setAutore(String autore) {
	this.autore = autore;
}
public String getGenere() {
	return genere;
}
public String getNome() {
	return nome;
}

public void setGenere(String genere) {
	this.genere = genere;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setPrezzo(float prezzo) {
	this.prezzo = prezzo;
}

}
