package it.unisa;

public class UserBean {
	
    private String nomeutente; 
    private String password;
    private String nome; 
    private String cognome;  
    private String mail;
    private String CF;
    private String tel;
    private String data;
    private String cap;
    private String via;
    private String civico;
    private String pro;
    private String cart;
    private String cvv;
    private String scad;
    private String intestatario;
    private int admin;
    
    public int getAdmin() {
		return admin;
	}
    public void setAdmin(int admin) {
		this.admin = admin;
	}
    
   private boolean valid;
	
	
    public String getnome() {
       return nome;
	}

    public void setnome(String newFirstName) {
       nome = newFirstName;
	}

	
    public String getcognome() {
       return cognome;
			}

    public void setcognome(String newLastName) {
       cognome = newLastName;
			}
			

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    public String getnomeutente() {
       return nomeutente;
			}

    public void setnomeutente(String newUsername) {
       nomeutente= newUsername;
			}

    public String getEmail() {
        return mail;
 	}
    
    public void setEmail(String email) {
		mail = email;
	}

    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}

	public String getCf() {
		return CF;
	}

	public void setCf(String x) {
		CF = x;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getScad() {
		return scad;
	}

	public void setScad(String scad) {
		this.scad = scad;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}	
}