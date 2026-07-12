package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Destino;

public class ArchivoUtil {

    public static void guardarDestino(Destino destino) {

        try {

            FileWriter archivo = new FileWriter("Destinos.txt", true);
            archivo.write(destino.getNombre() + "\n");
            archivo.close();

            System.out.println("Destino guardado con exito en el archivo");

        } catch(Exception e) {

            System.out.println("Error al guardar destino en el archivo " + e.getMessage());
        }
    }

    public static ArrayList<Destino> leerDestinos() {

        ArrayList<Destino> destinos = new ArrayList<>();

        try {

            FileReader archivo = new FileReader("Destinos.txt");
            BufferedReader br = new BufferedReader(archivo);

            String linea;

            while ((linea = br.readLine()) != null) {

                destinos.add(new Destino(linea));
            }

            archivo.close();
            br.close();
        } catch (Exception e) {

            System.out.println("Error al leer el archivo " + e.getMessage());
        }

        return destinos;
    }
   
}
