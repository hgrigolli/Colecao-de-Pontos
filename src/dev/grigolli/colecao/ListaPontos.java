package dev.grigolli.colecao;

import javax.swing.JOptionPane;

import dev.grigolli.exception.NaoFoiPossivelIncluirException;
import dev.grigolli.exception.NaoFoiPossivelRemoverException;
import dev.grigolli.exception.PosicaoInvalidaException;
import dev.grigolli.exception.QuantidadeInvalidaExceptions;

public class ListaPontos {
    private Ponto pontos[];
    private int validos;
    

    public ListaPontos(int n){
        this.pontos = new Ponto[n];
        this.validos = 0;
    }

    public void adicionaFinal(Ponto ponto) throws NaoFoiPossivelIncluirException {
        int i = 0;
        while(i < this.pontos.length && this.pontos[i] != null){
            i++;
        }
        if(this.validos == this.pontos.length){
            throw new NaoFoiPossivelIncluirException("Colecao atual ja esta completa.");
        }
        this.pontos[i] = ponto;
        this.validos++;
    }
    public void adicionaPosicao(Ponto ponto, int posicao) throws NaoFoiPossivelIncluirException, PosicaoInvalidaException {
        if(posicao >= this.pontos.length){
            throw new PosicaoInvalidaException("Posicao " + posicao + " invalida. ");
        }
        if (this.pontos[posicao] != null) {
            if(this.validos == this.pontos.length){
                throw new NaoFoiPossivelIncluirException("Colecao atual ja esta completa.");
            } else {
                //Desloca para direita
                for(int i = this.validos - 1; i >= posicao; i--){
                    this.pontos[i+1] = this.pontos[i];
                }
                this.pontos[posicao] = ponto;
                validos++;
            }
        } else {
            //Procura a proxima posição livre
            int i = 0;
            while(this.pontos[i] != null){
                i++;
            }
            this.pontos[i] = ponto;
            this.validos++;
        }

    }

    public Double encontrarMaiorDistancia() throws QuantidadeInvalidaExceptions {
        if(this.validos < 2){
            throw new QuantidadeInvalidaExceptions("Quantidade de pontos na colecao eh menor do que dois");
        }
        Double maiorDistancia = (double) 0;
        for(int i = 0; i < this.validos; i++){
            Ponto p1 = this.pontos[i];
            for(int j = i+1; j < this.validos; j++){
                Ponto p2 = this.pontos[j];
                Double distancia = distanciaEntreDoisPontos(p1, p2);
                if(distancia > maiorDistancia){
                    maiorDistancia = distancia;
                }
            }

        }

        return maiorDistancia;

    }

    private Double distanciaEntreDoisPontos(Ponto p1, Ponto p2){
        int deltaX = p1.getX() - p2.getX();
        int deltaY = p1.getY() - p2.getY();

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }
    
    
    //metodo que remove o elemento da lista a partir do parametro posicao (informada pelo usuario)
    public void removePonto(int posicao) throws NaoFoiPossivelRemoverException, PosicaoInvalidaException {
    	//condicao de input valido pelo usuario
    	if(posicao >= this.pontos.length){ 
            throw new PosicaoInvalidaException("Posicao " + posicao + " invalida. ");
        }
        if (this.pontos[posicao] != null) {
            if(posicao > this.validos){
                throw new NaoFoiPossivelRemoverException("A posicao � maior que o tamanho da lista atual.");
            } else {
                //Desloca os elementos para a esquerda e atualiza o numero valido de elementos na lista de pontos
                for(int i = posicao+1; i < this.validos; i++){
                    this.pontos[i-1] = this.pontos[i];
                    
                }
                this.pontos[this.validos-1] = null;
                validos--;
            }
        } 
    }
    
    
    //metodo para encontrar um ponto na lista de pontos
    public int encontraPontoNaLista(Ponto p) {
    	int i;
    	for (i = 0; i < validos; i++) {
    		if (p.igual(getPontos()[i])) {
        		break;
        	}
        }
    	return i;
    }
    

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        for(Ponto p : this.pontos){
            if(p != null){
                sb.append(" (").append(p.getX()).append(",").append(p.getY()).append(") ");
            }
        }
        sb.append(" ]");

        return sb.toString();
    }

    public Ponto[] getPontos() {
        return pontos;
    }

    public int getValidos() {
        return validos;
    }
}
