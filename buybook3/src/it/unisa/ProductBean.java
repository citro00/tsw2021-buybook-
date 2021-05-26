package it.unisa;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String codice;
	String nome;
	String autore;
	String genere;
	float prezzo;
	int quantit�;
	int sconto;
	
	public ProductBean() {
		codice ="";
		nome = "";
		autore="";
		genere = "";
		quantit� = 0;
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

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantity) {
		this.quantit� = quantity;
	}

	@Override
	public String toString() {
		return nome + " (" + codice + "), " + prezzo + " " + quantit� + ". " + genere+ " "+sconto;
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
