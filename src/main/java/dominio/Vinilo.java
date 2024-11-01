package dominio;

public class Vinilo {
    private final String nombre;
    private final String nombreDisco;
    private final int ano;

    public Vinilo(String nombre, String nombreDisco, int anoLanzamiento) {
        this.nombre = nombre;
        this.nombreDisco = nombreDisco;
        this.ano = anoLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public int getAno() {
        return ano;
    }
}
