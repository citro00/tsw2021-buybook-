package it.unisa;

public class CartProduct {
	private ProductBean prodotto;
	private int Pezzi;
	public CartProduct(ProductBean b) {
		setProdotto(b);
		this.Pezzi=1;
	}
	
	//I get del carello
	public int getPezzi() {
		return Pezzi;
	}
	
	 
	public ProductBean getProdotto() {
		return prodotto;
	}
	public void setProdotto(ProductBean prodotto) {
		this.prodotto = prodotto;
	}
	public void setPezzi(int pezzi) {
		Pezzi = pezzi;
	}
	public Float getPrezzo() {
		return this.prodotto.getPrezzo();
	}
	public String getIDProdotto() {
		return this.prodotto.getCodice();
	}
	public String getNome() {
		return this.prodotto.getName();
	}
	public String getDescrizione() {
		return this.prodotto.getgenere();
	}
	public int getSconto() {
		return this.prodotto.getSconto();
	}
	public int getDisponibilità() {
		return this.prodotto.getQuantità();
	}
	
	public void incrementa() {
		this.Pezzi=this.Pezzi+1;
	}
	public void decrementa() {
		this.Pezzi=this.Pezzi-1;
	}

	public float Costototale() {
		float costo= this.Pezzi*this.prodotto.getPrezzo();
		return costo;
	}
	
	public void cancellaOrdine() {
		this.Pezzi=0;
	}
	
	
}
