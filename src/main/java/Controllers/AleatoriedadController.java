package Controllers;

public class AleatoriedadController {

    public static int generarRndInt(int min, int max) {
        double rand = Math.random();
        return (int) (min + Math.ceil(rand*(max - min)));
    }

    public static boolean sortearAccion(double prob) {
        double rand = Math.random();
        return Double.compare(rand, prob)<0;
    }

    public static double numeroAzar() {
        return Math.random();
    }
}
