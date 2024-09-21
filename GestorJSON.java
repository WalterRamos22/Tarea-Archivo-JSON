package proyecto;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class GestorJSON {
	
	private static final String FILE_PATH = "archivo.json";

    public void escribirJSON(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            JSONArray jsonArray = leerArchivoJSON();

            JSONObject obj = new JSONObject();
            System.out.println("Introduce el nombre: ");
            obj.put("nombre", scanner.nextLine());

            System.out.println("Introduce la edad: ");
            obj.put("edad", scanner.nextInt());
            scanner.nextLine(); // Consumir el salto de línea

            System.out.println("Introduce la ciudad: ");
            obj.put("ciudad", scanner.nextLine());

            jsonArray.put(obj);

            try (FileWriter file = new FileWriter(FILE_PATH)) {
                file.write(jsonArray.toString());
                file.flush();
                System.out.println("Datos escritos en " + FILE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("¿Deseas ingresar nuevos datos? (si/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                continuar = false;
            }
        }
    }

    public void leerJSON() {
        JSONArray jsonArray = leerArchivoJSON();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String nombre = obj.getString("nombre");
            int edad = obj.getInt("edad");
            String ciudad = obj.getString("ciudad");

            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad: " + ciudad);
            System.out.println("-----");
        }
    }

    private JSONArray leerArchivoJSON() {
        JSONArray jsonArray = new JSONArray();

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            jsonArray = new JSONArray(content);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        }

        return jsonArray;
    }
}