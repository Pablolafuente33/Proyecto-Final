package PartidasGuardadas;

import EstructurasDeDatos.ListaSimple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderPartidas {
public static ListaSimple<String> leerPartidas(String fileName) {
        ListaSimple<String> partidas = new ListaSimple<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf("Nombre Partida");
                if (index != -1) {
                    //Extraemos el nombre de la partida y lo agragamos a la lista.
                    String nombrePartida = line.substring(index + "Nombre Partida".length());
                    partidas.add(nombrePartida.trim()); //.trim lo utilizamos para eliminar los espacios blancos del principio y de final.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidas;
    }

}
