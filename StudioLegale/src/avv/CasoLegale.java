package avv;

public class CasoLegale {
	 private Cliente cliente;
	    private int numeroCaso;
	    private String descrizione;
	    private String stato;

	    // Costruttore
	    public CasoLegale(Cliente cliente, int numeroCaso, String descrizione, String stato) {
	        this.cliente = cliente;
	        this.numeroCaso = numeroCaso;
	        this.descrizione = descrizione;
	        this.stato = stato;
	    }

	    // Metodi getter
	    public Cliente getCliente() {
	        return cliente;
	    }

	    public int getNumeroCaso() {
	        return numeroCaso;
	    }

	    public String getDescrizione() {
	        return descrizione;
	    }

	    public String getStato() {
	        return stato;
	    }

	    // Metodo per modificare lo stato del caso legale
	    public void setStato(String nuovoStato) {
	        this.stato = nuovoStato;
	    }
	}
