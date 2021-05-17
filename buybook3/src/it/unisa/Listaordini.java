package it.unisa;

import java.util.ArrayList;
import java.util.List;

public class Listaordini {
	private List<OrdiniBean> Listaordini;
	
	public Listaordini() {
		Listaordini = new ArrayList<OrdiniBean>();
		
	}	
	public void Aggiungiordine(OrdiniBean o) {
		Listaordini.add(o);
	}
	public List<OrdiniBean> getListaordini() {
		return Listaordini;
	}
	
	public void setListaordini(List<OrdiniBean> listaordini) {
		Listaordini = listaordini;
	}
	
}
