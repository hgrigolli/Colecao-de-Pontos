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
    
    public boolean igual(Ponto p) {
    	return this.x == p.x && this.y == p.y;
    }

    @Override
    public String toString(){
        return "( " + this.x + " , " + this.y + " )";
    }
}
