package avv;
import java.util.Scanner;
public class StudioLegaleMain {

	public static void main(String[] args) {
		 StudioAvvocati studio = new StudioAvvocati();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            // Mostra il menu
	        	System.out.println("\nBenvenuto in studio legale, scegli un opzione dal menu!");
	        	System.out.println("Menu:");
	            System.out.println("1. Aggiungi nuovo cliente");
	            System.out.println("2. Aggiungi nuovo caso legale");
	            System.out.println("3. Visualizza lista clienti");
	            System.out.println("4. Visualizza dettagli cliente");
	            System.out.println("5. Visualizza dettagli caso legale");
	            System.out.println("6. Modifica stato caso legale");
	            System.out.println("7. Elimina cliente");
	            System.out.println("0. Esci");

	            int scelta = scanner.nextInt();
	            scanner.nextLine();  // Consuma il carattere newline

	            
	            switch (scelta) {
	                case 1:
	                	 // Aggiungi un nuovo cliente
	                    System.out.println("Inserisci il nome del cliente:");
	                    String nomeCliente = scanner.nextLine();
	                    
	                    System.out.println("Inserisci il codice fiscale del cliente:");
	                    String codiceFiscaleCliente = scanner.nextLine();
	                    
	                    System.out.println("Inserisci il telefono del cliente:");
	                    String telefonoCliente = scanner.nextLine();
	                    
	                    //nell'inserimento dati, verifico sia un indirizzo mail valido
	                    String emailCliente;
	                    do {
	                        System.out.println("Inserisci l'email del cliente:");
	                        emailCliente = scanner.nextLine();

	                        if (!emailCliente.contains("@")) {
	                            System.out.println("Inserisci un indirizzo email valido!");
	                        }
	                    } while (!emailCliente.contains("@"));

	                    Cliente nuovoCliente = new Cliente(nomeCliente, codiceFiscaleCliente, telefonoCliente, emailCliente);
	                    studio.aggiungiCliente(nuovoCliente);
	                    System.out.println("Cliente aggiunto con successo.");
	                    break;
	                    
	                case 2:
	                    // Richiedi e aggiungi un nuovo caso legale
	                    System.out.println("Inserisci numero del caso legale:");
	                    int numeroCaso = scanner.nextInt();
	                    scanner.nextLine();  

	                    System.out.println("Inserisci descrizione del caso legale:");
	                    String descrizioneCaso = scanner.nextLine();

	                    System.out.println("Inserisci stato del caso legale:");
	                    String statoCaso = scanner.nextLine();

	                    // Mostra la lista dei clienti disponibili per associare il caso legale
	                    System.out.println("Lista dei clienti disponibili da associare a questo caso elencati per ccodice fiscale:");
	                    for (int i = 0; i < studio.getListaClienti().size(); i++) {
	                        Cliente cliente = studio.getListaClienti().get(i);
	                        System.out.println((i + 1) + ". " + cliente.getCodiceFiscale());
	                    }

	                    System.out.println("Inserisci il numero corrispondente del cliente da abbinare a questo caso:");
	                    int sceltaCliente = scanner.nextInt();
	                    scanner.nextLine();  

	                    // Verifica che l'input sia valido
	                    if (sceltaCliente > 0 && sceltaCliente <= studio.getListaClienti().size()) {
	                        Cliente clienteAssociato = studio.getListaClienti().get(sceltaCliente - 1);

	                        // Crea il caso legale e aggiungilo alla lista dei casi legali
	                        CasoLegale nuovoCasoLegale = new CasoLegale(clienteAssociato, numeroCaso, descrizioneCaso, statoCaso);
	                        studio.aggiungiCasoLegale(nuovoCasoLegale);
	                        System.out.println("Nuovo caso legale aggiunto con successo.");
	                    } else {
	                        System.out.println("Selezione del cliente non valida.");
	                    }
	                    break;
	                    
	                case 3:
	                    // Visualizza elenco clienti con nome e codice fiscale
	                    System.out.println("Elenco clienti:");
	                    for (Cliente cliente : studio.getListaClienti()) {
	                        System.out.println("Nome: " + cliente.getNome() + ", Codice Fiscale: " + cliente.getCodiceFiscale());
	                    }
	                    break;
	                    
	                case 4:
	                
	                 // Visualizza dettagli cliente
	                    System.out.println("Inserisci il codice fiscale del cliente:");
	                    String codiceFiscaleDaVisualizzare = scanner.nextLine();

	                    // Cerca il cliente nella lista
	                    Cliente clienteDaVisualizzare = null;
	                    for (Cliente cliente : studio.getListaClienti()) {
	                    	if (cliente.getCodiceFiscale().equalsIgnoreCase(codiceFiscaleDaVisualizzare)) {
	                            clienteDaVisualizzare = cliente;
	                            break;
	                        }
	                    }

	                    // Se il cliente è stato trovato, visualizza i dettagli
	                    if (clienteDaVisualizzare != null) {
	                        System.out.println("Dettagli del cliente:");
	                        System.out.println("Nome: " + clienteDaVisualizzare.getNome());
	                        System.out.println("Codice Fiscale: " + clienteDaVisualizzare.getCodiceFiscale());
	                        System.out.println("Telefono: " + clienteDaVisualizzare.getTelefono());
	                        System.out.println("Email: " + clienteDaVisualizzare.getEmail());
	                        
	                     // Visualizza i casi legali associati al cliente
	                        System.out.println("Casi legali associati:");
	                        for (CasoLegale casoLegale : studio.getListaCasiLegali()) {
	                            if (casoLegale.getCliente().equals(clienteDaVisualizzare)) {
	                                System.out.println("Numero caso legale: " + casoLegale.getNumeroCaso());
	                                System.out.println("Descrizione: " + casoLegale.getDescrizione());
	                                System.out.println("Stato: " + casoLegale.getStato());
	                                
	                            }
	                        }
	                    } else {
	                        System.out.println("Cliente non trovato.");
	                    }
	                    break;
	                    
	                case 5:
	                    // Richiedi e visualizza dettagli caso legale
	                    System.out.println("Inserisci il numero del caso legale:");
	                    int numeroCasoLegaleDaVisualizzare = scanner.nextInt();
	                    scanner.nextLine();  // Consuma il carattere newline

	                    // Cerca il caso legale nella lista
	                    CasoLegale casoLegaleDaVisualizzare = null;
	                    for (CasoLegale casoLegale : studio.getListaCasiLegali()) {
	                        if (casoLegale.getNumeroCaso() == numeroCasoLegaleDaVisualizzare) {
	                            casoLegaleDaVisualizzare = casoLegale;
	                            break;
	                        }
	                    }

	                    // Se il caso legale è stato trovato, visualizza i dettagli
	                    if (casoLegaleDaVisualizzare != null) {
	                    	Cliente clienteAssociato = casoLegaleDaVisualizzare.getCliente();
	                    	
	                        System.out.println("Dettagli del caso legale:");
	                        System.out.println("Numero caso legale: " + casoLegaleDaVisualizzare.getNumeroCaso());
	                        System.out.println("Descrizione: " + casoLegaleDaVisualizzare.getDescrizione());
	                        System.out.println("Stato: " + casoLegaleDaVisualizzare.getStato());
	                        System.out.println("Cliente associato:");
	                        System.out.println("Nome: " + clienteAssociato.getNome());
	                        System.out.println("Codice Fiscale: " + clienteAssociato.getCodiceFiscale());
	                    } else {
	                        System.out.println("Caso legale non trovato.");
	                    }
	                    break;

	                case 6:
	                    // Richiedi e modifica stato caso legale
	                    System.out.println("Inserisci il numero del caso legale da modificare:");
	                    int numeroCasoLegaleDaModificare = scanner.nextInt();
	                    scanner.nextLine();  // Consuma il carattere newline

	                    // Cerca il caso legale nella lista
	                    CasoLegale casoLegaleDaModificare = null;
	                    for (CasoLegale casoLegale : studio.getListaCasiLegali()) {
	                        if (casoLegale.getNumeroCaso() == numeroCasoLegaleDaModificare) {
	                            casoLegaleDaModificare = casoLegale;
	                            break;
	                        }
	                    }

	                    // Se il caso legale è stato trovato, richiedi il nuovo stato e modificalo
	                    if (casoLegaleDaModificare != null) {
	                        System.out.println("Inserisci il nuovo stato del caso legale:");
	                        String nuovoStatoCaso = scanner.nextLine();

	                        studio.modificaStatoCasoLegale(casoLegaleDaModificare, nuovoStatoCaso);
	                        System.out.println("Stato del caso legale modificato con successo.");
	                    } else {
	                        System.out.println("Caso legale non trovato.");
	                    }
	                    break;

	                case 7:
	                    // Richiedi e elimina cliente
	                    System.out.println("Inserisci il nome del cliente da eliminare:");
	                    String nomeClienteDaEliminare = scanner.nextLine();

	                    // Cerca il cliente nella lista
	                    Cliente clienteDaEliminare = null;
	                    for (Cliente cliente : studio.getListaClienti()) {
	                        if (cliente.getNome().equalsIgnoreCase(nomeClienteDaEliminare)) {
	                            clienteDaEliminare = cliente;
	                            break;
	                        }
	                    }

	                    // Se il cliente è stato trovato, eliminalo
	                    if (clienteDaEliminare != null) {
	                        studio.eliminaCliente(clienteDaEliminare);
	                        System.out.println("Cliente eliminato con successo.");
	                    } else {
	                        System.out.println("Cliente non trovato.");
	                    }
	                    break;
	                    
	                case 0:
	                    // Esci dall'applicazione
	                    System.out.println("Arrivederci!");
	                    System.exit(0);
	                    break;
	                    
	                default:
	                    System.out.println("Scelta non valida. Riprova.");
	                    break;

	            }
	        }
	}
}
