package Exceptions;

public class ColaVaciaException extends Exception{
    public ColaVaciaException(String mensage){
        super(mensage);
        System.out.println("La cola está vacia");
    }
}
