package avv;

public class Cliente {
	private String nome;
    private String codiceFiscale;
    private String telefono;
    private String email;

    // Costruttore
    public Cliente(String nome, String codiceFiscale, String telefono, String email) {
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.telefono = telefono;
        this.email = email;
    }

    // Metodi getter
    public String getNome() {
        return nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}

