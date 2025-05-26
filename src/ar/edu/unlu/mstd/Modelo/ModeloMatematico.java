package ar.edu.unlu.mstd.Modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ModeloMatematico {
    private int cantidadArroz;
    private int cantEnCuadrado;
    private int cantEnCirculo;
    private ArrayList<Double> probCirculo;
    private ArrayList<Double> probCuadrado;

    public ModeloMatematico(int cantA){
        cantidadArroz = cantA;
        probCirculo = new ArrayList<>();
        probCuadrado = new ArrayList<>();
    }

    public void lanzarArroz(){
        cantEnCirculo = 0;
        cantEnCuadrado = 0;
        double arrozActual;
        double valorLimite = Math.PI / 4;
        for (int i = 0; i < cantidadArroz; i++) {
            arrozActual = (Math.random() * 1);
            if (arrozActual < valorLimite){
                cantEnCirculo++;
                probCirculo.add(arrozActual);
            }else {
                cantEnCuadrado++;
                probCuadrado.add(arrozActual);
            }
        }
    }

    public int getCantEnCirculo() {
        return cantEnCirculo;
    }

    public int getCantEnCuadrado() {
        return cantEnCuadrado;
    }

    public double getProbArrozCirculo(int nroArroz) {
        return probCirculo.get(nroArroz);
    }
    public double getProbArrozCuadrado(int nroArroz) {
        return probCuadrado.get(nroArroz);
    }
}
