/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

import java.util.Random;


public class Individuo {
    private int[] genotipo;
    private int fitness;

    public Individuo(){
        this.genotipo = new int[16];
        this.iniciarGenotipo();
        this.calcularFitness();
    }

    public Individuo(int[] genotipo) {
        this.genotipo = genotipo;
        this.calcularFitness();
    }
    
    
    
    public void iniciarGenotipo(){
        Random r = new Random();
        for(int i = 0; i < this.genotipo.length; i++){
            this.genotipo[i] = r.nextInt(2);
        }
    }
    
    public void calcularFitness(){
            String binario = "";
                for(int i = 0; i < this.genotipo.length; i++){
                    binario += this.genotipo[i];
                }
            this.fitness = Integer.parseInt(binario,2);
    }
    
       
    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }
    
}
