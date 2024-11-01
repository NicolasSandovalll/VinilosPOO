package dominio;

import java.util.ArrayList;
import java.util.List;

public class ViniloManager {
    private final List<Vinilo> coleccionVinilos;

    public ViniloManager() {
        this.coleccionVinilos = new ArrayList<>();
    }

    public void agregarVinilo(String nombre, String nombreDisco, int anoLanzamiento) {
        int anoActual = java.time.Year.now().getValue(); // Obtiene el año actual

        // Validaciones de entrada
        if (nombre == null || nombre.isEmpty() || nombreDisco == null || nombreDisco.length() < 3 ||
                anoLanzamiento < 1890 || anoLanzamiento > anoActual) { // El año 1890 porque en ese año marca el comienzo de los discos comerciales según ChatGPT
            System.out.println("Datos inválidos. No se puede agregar el vinilo");
            return; // Terminar el método sin agregar nada a la colección de vinilos
        }

        // Verificar si el vinilo ya existe
        for (Vinilo vinilo : coleccionVinilos) {
            if (vinilo.getNombre().equalsIgnoreCase(nombre) &&
                    vinilo.getNombreDisco().equalsIgnoreCase(nombreDisco) &&
                    vinilo.getAno() == anoLanzamiento) {
                System.out.println("El vinilo ya existe en la colección.");
                return; // Termina el método sin agregar nada
            }
        }

        // Agregar vinilo si no se encuentra duplicado y la colección no está llena
        if (coleccionVinilos.size() < 100) {
            Vinilo viniloAAgregar = new Vinilo(nombre, nombreDisco, anoLanzamiento);
            coleccionVinilos.add(viniloAAgregar);
            System.out.println("Vinilo agregado a la colección.");
        } else {
            System.out.println("La colección se encuentra llena.");
        }
    }


    public boolean buscarVinilo(String nombre, String nombreDisco, int anoLanzamiento) {
        for (Vinilo vinilo : coleccionVinilos) {
            if (vinilo.getNombre().replace(" ", "").equalsIgnoreCase(nombre.replace(" ", "")) &&
                    vinilo.getNombreDisco().replace(" ", "").equalsIgnoreCase(nombreDisco.replace(" ", "")) &&
                    vinilo.getAno() == anoLanzamiento) {
                return true;
            }
        }
        return false;
    }

    public int cantidadVinilos() {
        return coleccionVinilos.size();
    }

    public int espaciosDisponibles() {
        return 100 - cantidadVinilos();
    }
}
