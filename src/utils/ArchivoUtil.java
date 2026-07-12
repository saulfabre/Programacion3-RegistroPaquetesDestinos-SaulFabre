package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Destino;
import model.Paquete;

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

    public static void guardarPaquete(Paquete paquete) {

        try {

        FileWriter archivo = new FileWriter("Paquetes.txt", true);
        archivo.write(paquete.getCodigo() + ";" + paquete.getDestinatario() + ";" + paquete.getPeso() + ";" + paquete.getDestino() + "\n");
        archivo.close();

        System.out.println("Paquete guardado con exito en el archivo");

        } catch(Exception e) {
            System.out.println("Error al guardar paquete en el archivo " + e.getMessage());
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

        } catch (IOException e) {

            System.out.println("Error al leer el archivo " + e.getMessage());
        }

        return destinos;
    }

    public static ArrayList<Paquete> leerPaquetes() {

        ArrayList<Paquete> paquetes = new ArrayList<>();

        try {

        FileReader archivo = new FileReader("Paquetes.txt");
        BufferedReader br = new BufferedReader(archivo);

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] partes = linea.split(";");

            paquetes.add(new Paquete(partes[0], partes[1], Double.parseDouble(partes[2]), partes[3]));
        }

        archivo.close();
        br.close();

    } catch(IOException e) {

        System.out.println("Error al leer el archivo " + e.getMessage());
    }

    return paquetes;

    }
}
