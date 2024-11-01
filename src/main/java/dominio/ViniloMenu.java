package dominio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViniloMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private final ViniloManager viniloManager;

    public ViniloMenu() {
        this.viniloManager = new ViniloManager();
    }

    public void iniciarPrograma() {
        int opcion;
        do {
            mostrarMenu();
            opcion = solicitarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n Bienvenido \n");
        System.out.println("1.- Agregar un vinilo a la colección");
        System.out.println("2.- Buscar un vinilo");
        System.out.println("3.- Cantidad de vinilos en la colección");
        System.out.println("4.- Espacios disponibles");
        System.out.println("5.- Salir\n");
    }

    private int solicitarOpcion() {
        while (true) {
            try {
                System.out.print("Ingrese una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("Por favor, ingrese una opción entre 1 y 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Carácteres inválidos. Por favor ingrese una opción entre 1 y 5.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    private int solicitarAno() {
        while (true) {
            try {
                System.out.print("Ingrese el año de lanzamiento: ");
                int ano = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                return ano;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números para el año.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                AgregarVinilo();
                break;
            case 2:
                buscarVinilo();
                break;
            case 3:
                System.out.println("La cantidad de vinilos es: " + viniloManager.cantidadVinilos());
                break;
            case 4:
                System.out.println("La cantidad de espacios disponibles es: " + viniloManager.espaciosDisponibles());
                break;
            case 5:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private void AgregarVinilo() {
        System.out.print("Ingrese el nombre del artista: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del Disco: ");
        String nombreDisco = scanner.nextLine();
        int anoLanzamiento = solicitarAno();
        viniloManager.agregarVinilo(nombre, nombreDisco, anoLanzamiento);
    }

    private void buscarVinilo() {
        if (viniloManager.cantidadVinilos() != 0) {
            System.out.print("Ingrese el nombre del artista: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nombre del Disco: ");
            String nombreDisco = scanner.nextLine();
            int anoLanzamiento = solicitarAno();
            if (viniloManager.buscarVinilo(nombre, nombreDisco, anoLanzamiento)) {
                System.out.println("El vinilo se encuentra en la colección.");
            } else {
                System.out.println("El vinilo no se encuentra en la colección.");
            }
        } else {
            System.out.println("La colección se encuentra vacía.");
        }
    }
}
