package Controllers;

import comun.Posicion;

public class PrintController {

    public static String printPosicion(Posicion posicion) {
        return posicion.getX() + "," + posicion.getY();
    }
}
