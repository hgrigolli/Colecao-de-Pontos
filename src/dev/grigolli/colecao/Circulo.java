package dev.grigolli.colecao;

import javax.swing.JOptionPane;

import dev.grigolli.exception.NaoFoiPossivelIncluirException;

public class Circulo {
	
	private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    //metodo que verifica se um ponto esta no circulo, a partir da distancia do raio
    public boolean estaDentro(Ponto p){
        return this.centro.distancia(p) <= this.raio;       
    }
    
    
    //metodo que verifica os pontos que estao no circulo e insere em uma nova lista
    public ListaPontos pontosNoCirculo(ListaPontos listaPontos) throws NaoFoiPossivelIncluirException {
        ListaPontos listaPontosCirculo = new ListaPontos(listaPontos.getValidos());
        for (int i = 0; i < listaPontos.getValidos(); i++ ) {
    		if (estaDentro(listaPontos.getPontos()[i])) { //chama o metodo que verifica se o ponto da lista principal esta no circulo (se true, adiciona na nova lista)
    			listaPontosCirculo.adicionaFinal(listaPontos.getPontos()[i]);
    		}	
    	}

        return listaPontosCirculo;
    }
    
}
