package dev.grigolli.colecao;

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
            throw new NaoFoiPossivelIncluirException("Coleção atual já está completa.");
        }
        this.pontos[i] = ponto;
        this.validos++;
    }
    public void adicionaPosicao(Ponto ponto, int posicao) throws NaoFoiPossivelIncluirException {
        if(posicao >= this.pontos.length){
            throw new NaoFoiPossivelIncluirException("Posição " + posicao + " inválida. ");
        }
        if (this.pontos[posicao] != null) {
            if(this.validos == this.pontos.length){
                throw new NaoFoiPossivelIncluirException("Coleção atual já está completa.");
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
