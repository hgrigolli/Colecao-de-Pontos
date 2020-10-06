package dev.grigolli.colecao;

public class Ponto {
    private int x,y;
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    //verifica se os valores do ponto inserido pelo usuario, sera igual a algum ponto da lista de pontos
    public boolean igual(Ponto p) {
    	return this.x == p.x && this.y == p.y;
    }
    
    //metodo que verifica a distancia de um ponto com outro
    public double distancia(Ponto p) {
        int c1 = this.x - p.x;
        int c2 = this.y - p.y;
        return Math.sqrt(c1*c1+c2*c2);
    }
    

    @Override
    public String toString(){
        return "( " + this.x + " , " + this.y + " )";
    }
}
