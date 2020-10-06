package dev.grigolli.colecao;

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
}
