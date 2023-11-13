package avv;
import java.util.ArrayList;
public class StudioAvvocati {
	 private ArrayList<Cliente> listaClienti;
	    private ArrayList<CasoLegale> listaCasiLegali;

	    // Costruttore
	    public StudioAvvocati() {
	        this.listaClienti = new ArrayList<>();
	        this.listaCasiLegali = new ArrayList<>();
	    }

//METODI :
	    
	    // 1 Aggiungi cliente
	    public void aggiungiCliente(Cliente cliente) {
	        listaClienti.add(cliente);
	    }
	    
	    // 2 aggiungi nuovo caso legale
	    public void aggiungiCasoLegale(CasoLegale casoLegale) {
	        listaCasiLegali.add(casoLegale);
	    }
	    
	    //3 visualizza dettagli cliente
	    public void visualizzaDettagliCliente(Cliente cliente) {
	    	//
	    }
	    
	    // 4 visualizza dettagli caso
	    public void visualizzaDettagliCasoLegale(CasoLegale casoLegale) {
	        //
	    }
	    
	    // 5 modifica stato caso
	    public void modificaStatoCasoLegale(CasoLegale casoLegale, String nuovoStato) {
	        casoLegale.setStato(nuovoStato);
	    }
	    
	    //6 elimina cliente
	    public void eliminaCliente(Cliente cliente) {
	        listaClienti.remove(cliente);
	    }
	   
	    
	    // Metodo getter per la lista dei clienti
	    public ArrayList<Cliente> getListaClienti() {
	        return listaClienti;
	    }
	    // Metodo getter per la lista dei casi
	    public ArrayList<CasoLegale> getListaCasiLegali() {
	        return listaCasiLegali;
	    }
	    
	}

