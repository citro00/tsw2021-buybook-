package it.unisa;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<CartProduct> prodotti;
	
	public Cart() {
		prodotti = new ArrayList<CartProduct>();
	}
	
	public synchronized void addProduct(CartProduct cart) {
		CartProduct order;
        for(int i=0; i<prodotti.size(); i++) {
          order = prodotti.get(i);
          if (order.getIDProdotto().equals(cart.getIDProdotto())) {
              if(order.getPezzi()<cart.getDisponibilità())
            order.incrementa();
            return;
          }

  }
        prodotti.add(cart);
  }

public void deleteProduct(CartProduct cart) {
     CartProduct order;
        for(int i=0; i<prodotti.size(); i++) {
          order = prodotti.get(i);
          if (order.getIDProdotto().equals(cart.getIDProdotto())) {
              if(order.getPezzi()>0)
            order.decrementa();
              else
                  order.cancellaOrdine();;
            return;
          }
        }
}
	

	public List<CartProduct> getProducts() {
		return  prodotti;
	}
}