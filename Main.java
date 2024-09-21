package proyecto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        GestorJSON gestorJSON = new GestorJSON();

        while (true) {
            System.out.println("¿Qué deseas hacer? (escribir/leer/salir): ");
            String accion = scanner.nextLine();

            if (accion.equalsIgnoreCase("escribir")) {
                gestorJSON.escribirJSON(scanner);
            } else if (accion.equalsIgnoreCase("leer")) {
                gestorJSON.leerJSON();
            } else if (accion.equalsIgnoreCase("salir")) {
                break;
            } else {
                System.out.println("Acción no reconocida.");
            }
        }

        scanner.close();
    }
}
