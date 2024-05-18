package com.example.demo;

import EstructurasDeDatos.HashMap;
import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Pila;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main_Pruebas {
    public HashMap<String, Integer> cargarParametro(String fileName){
        HashMap<String, Integer> parametros = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] partes = line.split("=");
                if (partes.length == 2){
                    parametros.put(partes[0], Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parametros;
    }
}

