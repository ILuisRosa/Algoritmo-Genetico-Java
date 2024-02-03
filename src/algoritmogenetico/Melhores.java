/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

/**
 *
 * @author Lab02
 */
public class Melhores {
    private Individuo individuo;
    private int indice;
    

    public Melhores(Individuo individuo, int indice) {
        this.individuo = individuo;
        this.indice = indice;
     
    }
    

    public Individuo getIndividuo() {
        return individuo;
    }

    public int getIndice() {
        return indice;
    }
    
    
    
}
