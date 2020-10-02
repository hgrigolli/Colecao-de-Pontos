package dev.grigolli.colecao;

public class ListaPontos {
    private Ponto pontos[];
    private int validos;

    public ListaPontos(int n){
        this.pontos = new Ponto[n];
        this.validos = 0;
    }

    public void adicionaFinal(Ponto ponto){
        int i = 0;
        while(this.pontos[i] != null){
            i++;
        }
        if(i > this.validos){
            return;
        } else {
            this.pontos[i] = ponto;
            this.validos++;
        }
    }
    public void adicionaPosicao(Ponto ponto, int posicao){
        if(posicao >= this.pontos.length){
            return;
        } else if (this.pontos[posicao] != null) {
            if(this.validos +1 >= this.pontos.length){
                //Ultrapassa o limite de pontos a ser incluidp
                return;
            }
        }

        if (this.pontos[0] == null){
            this.pontos[0] = ponto;
        }
        //TODO: deslocar para a direita
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


}
