package it.unisa;

import java.util.ArrayList;
import java.util.List;

public class ListaComposizioni {
private List<ComposizioneBean> Listacomposizone;
	
	public ListaComposizioni() {
		 Listacomposizone= new ArrayList<ComposizioneBean>();
		
	}	
	public void AggiungiComposizione( ComposizioneBean c) {
		Listacomposizone.add(c);
	}	
	public List<ComposizioneBean> getListacomposizone() {
		return Listacomposizone;
	}
	public void setListacomposizone(List<ComposizioneBean> listacomposizone) {
		Listacomposizone = listacomposizone;
	}
}
