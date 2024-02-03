/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

/**
 *
 * @author Lab02
 */
public class Controlador {

    private Individuo[] populacao;
    private Melhores[] campeoes;
    private Individuo melhorResposta;
    private int geracao;
  

    public Controlador(int tamanhoPopulacao, int tamanhoCampeoes, int geracao) {
        this.populacao = new Individuo[tamanhoPopulacao];   //conjunto de possiveis soluções
        this.campeoes = new Melhores[tamanhoCampeoes];  //conjunto dos 10 melhores fitness
        this.inicializarPopulacao();    
        this.inicializarCampeoes();
        this.melhorResposta = new Individuo();
        this.geracao = geracao;
    }

    private void inicializarPopulacao() {
        for (int i = 0; i < this.populacao.length; i++) {
            this.populacao[i] = new Individuo();
        }
    }

    
    //método que seleciona os 10 melhores fitness de toda população
    private void selecao() {
        for (int i = 0; i < this.populacao.length; i++) {
            int j = 0;
            boolean flag = false;
            while (j < this.campeoes.length && flag == false) {
                if (this.populacao[i].getFitness() < this.campeoes[j].getIndividuo().getFitness()) {
                    this.campeoes[j] = new Melhores(this.populacao[i], i);
                    flag = true;
                }
                j++;
            }

        }
    }

    //Instancia a estrtura de dados dos campeões
    private void inicializarCampeoes() {
        for (int i = 0; i < this.campeoes.length; i++) {
            this.campeoes[i] = new Melhores(new Individuo(), 0);
        }
    }

    //Método que substitui os pais pelos filhos na população
    private void substituiPaisporFilhos(Individuo filho, int indice) {
        this.populacao[indice] = filho;
    }

    
    //Metodo que deve ser implementado por vocês
    private void cruzamento() {
        int genotipoPai[];
        int genotipoMae[];
        int genotipoFilho[] = new int[16];
        int genotipoFilha[] = new int[16];

        for(int i = 0; i<this.campeoes.length;i = i+2){
            genotipoPai = this.campeoes[i].getIndividuo().getGenotipo();
            genotipoMae = this.campeoes[i+1].getIndividuo().getGenotipo();

            for(int j = 0; j < genotipoMae.length;j++){
                if(j<genotipoMae.length/2){
                genotipoFilha[j] = genotipoMae[j];
            
            }else{
                genotipoFilha[j] = genotipoPai[j];
                }               
            }

            for(int j = 0; j < genotipoPai.length;j++){
                if(j<genotipoPai.length/2){
                genotipoFilho[j] = genotipoPai[j];
            
            }else{
                genotipoFilho[j] = genotipoMae[j];
                }  
            }
            Individuo filho = new Individuo(genotipoFilho);
            Individuo filha = new Individuo(genotipoFilha);
            
            this.substituiPaisporFilhos(filho, this.campeoes[i].getIndice());
            this.substituiPaisporFilhos(filha, this.campeoes[i+1].getIndice());
        }   
    }

    
    //Metodo que contem a logica central de resolução do problema
    public void resolverProblema() {
        int i = 0;
        while (i < this.geracao) {
            this.selecao();
            this.selecionarMenorFitness();
            if(this.melhorResposta.getFitness() == 0){
                System.out.println("Foi encontrado a solução perfeita. Numero de gerações necessárias: " + i);
                return;
            }
            this.cruzamento();
            i++;
        }
        System.out.println(" Não foi encontrada uma solução perfeita. O fitness da melhor solução foi de: " + this.melhorResposta.getFitness());
    }


    //Seleciona o melhor fitness de toda geração
    private void selecionarMenorFitness() {
        for ( int i = 0; i < this.campeoes.length; i++) {
            if(this.campeoes[i].getIndividuo().getFitness() < this.melhorResposta.getFitness()){
                this.melhorResposta = this.campeoes[i].getIndividuo();
            }
        }
    }

}
