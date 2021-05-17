package it.unisa;

public class ComposizioneBean {
// variabili di istanze
	private  int quantità;
	private int id_ordine;
	private String codice;
	
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	public int getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
}
