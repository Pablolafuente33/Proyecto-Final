package PartidasGuardadas;

import EstructurasDeDatos.HashMap;
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
    public static ListaSimple<HashMap<String, String>> cargarParametro(String fileName){
        ListaSimple<HashMap<String, String>> listaHashMaps = new ListaSimple<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                HashMap<String, String> parametros = new HashMap<>();
                String[] pares = line.split(",");
                for (String par: pares){
                    String[] partes = par.split("=");
                    if (partes.length == 2) {
                        parametros.put(partes[0].trim(), partes[1].trim());
                    }
                }
                listaHashMaps.add(parametros);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaHashMaps;
    }
    public static ListaSimple<String> cargarNombresPartidas(String fileName){
        ListaSimple<String> nombrePartidas = new ListaSimple<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                nombrePartidas.add(line.trim());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return nombrePartidas;
    }
}
