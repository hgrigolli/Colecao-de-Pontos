package dev.grigolli;

import dev.grigolli.colecao.ListaPontos;
import dev.grigolli.exception.NaoFoiPossivelIncluirException;
import dev.grigolli.exception.NaoFoiPossivelRemoverException;
import dev.grigolli.colecao.Ponto;
import dev.grigolli.exception.PosicaoInvalidaException;
import dev.grigolli.exception.QuantidadeInvalidaExceptions;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String opcaoMenuStr;
        Integer opcaoMenu = 0;
        ListaPontos listaPontos = new ListaPontos(3); // Talvez mudar para pedir ao usuario um numero de pontos

        do {
            do {

                opcaoMenuStr = JOptionPane.showInputDialog(
                        "Henrique Nóbrega Grigolli - 41821661\n" +
                        "Kleber Takashi Yoshida - 41843533\n\n" +
                        "========MENU DE OPÇÕES========\n\n" +
                        "1. Adicionar um elemento no final da coleção\n" +
                        "2. Adicionar um elemento em uma posição da coleção\n" +
                        "3. Retornar o índice da primeira ocorrência de um elemento especificado na coleção\n" +
                        "4. Remover um elemento em uma posição na coleção\n" +
                        "5. Calcular a distância dos dois pontos mais distantes na coleção\n" +
                        "6. Retornar uma coleção de pontos contido em um círculo\n" +
                        "7. Sair do programa\n\n" +
                        "Coleção atual: " + listaPontos.toString() + "\n" +
                        "Coleção possui " + listaPontos.getValidos() + " elementos de " + listaPontos.getPontos().length + "\n\n");

                if(opcaoMenuStr == null || opcaoMenuStr.isBlank()){
                    opcaoMenu = null;
                    JOptionPane.showMessageDialog(null,"Favor escolher uma opção.");
                } else {
                    opcaoMenu = Integer.parseInt(opcaoMenuStr);
                }
            } while(opcaoMenu == null);

            Ponto elemento = new Ponto(0,0);
            switch(opcaoMenu) {
                case 1:

                    do {
                        JTextField x = new JTextField();
                        JTextField y = new JTextField();
                        Object[] ponto = {
                                "X: ", x,
                                "Y: ", y
                        };

                        int option = JOptionPane.showConfirmDialog(null, ponto, "Defina o ponto (x,y)", JOptionPane.OK_CANCEL_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            if(x.getText() != null && y.getText() !=null){
                                elemento = new Ponto(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
                            }
                        } else {
                            elemento = null;
                            break;
                        }
                    } while(elemento == null);

                    try {
                        listaPontos.adicionaFinal(elemento);
                    } catch (NaoFoiPossivelIncluirException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;

                case 2:
                    int pos = 0;
                    do {
                        JTextField x = new JTextField();
                        JTextField y = new JTextField();
                        JTextField posicao = new JTextField();

                        Object[] ponto = {
                                "Defina o ponto (x,y) e a posição a ser inserida", null,
                                "X: ", x,
                                "Y: ", y,
                                "Posicao: ", posicao
                        };

                        int option = JOptionPane.showConfirmDialog(null, ponto, "Defina o ponto (x,y) e a posição a ser inserida", JOptionPane.OK_CANCEL_OPTION);


                        if (option == JOptionPane.OK_OPTION) {
                            if(x.getText() != null && y.getText() !=null){
                                elemento = new Ponto(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));

                            }
                            if(posicao.getText() != null){
                                pos = Integer.parseInt(posicao.getText());
                            }
                        } else {
                            elemento = null;
                            break;
                        }
                    } while(elemento == null);

                    try {
                        listaPontos.adicionaPosicao(elemento, pos);
                    } catch (NaoFoiPossivelIncluirException | PosicaoInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;

                case 3:
                	
                	boolean achou = false;
                	
                	do {
                    	JTextField x = new JTextField();
                        JTextField y = new JTextField();
                        
                        Object[] ponto = {
                                "Defina o ponto (x,y) para realizar a busca", null,
                                "X: ", x,
                                "Y: ", y,
                        };
                    	
                    	int elementoBuscado = JOptionPane.showConfirmDialog(null, ponto, "Insira o valor do elemento a ser buscado", JOptionPane.OK_CANCEL_OPTION);
                    	if (elementoBuscado == JOptionPane.OK_OPTION) {
                            if(x.getText() != null && y.getText() !=null){
                                elemento = new Ponto(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
                            }
                        } else {
                            elemento = null;
                            break;
                        }
                    } while(elemento == null);

                    for (int i = 0; i < listaPontos.getValidos(); i++) {
                		if (elemento.igual(listaPontos.getPontos()[i])) {
                    		achou = true;
                			String mensagem = "Encontrado na posicao " + i + " da lista.";
                    		JOptionPane.showMessageDialog(null, mensagem);
                    		break;
                    	}
                    }
                	
                    if (achou == false) {
                		String mensagemNaoEncontrado = "Ponto nao se encontra na lista ";
                		JOptionPane.showMessageDialog(null, mensagemNaoEncontrado); 
                	}

                    break;

                case 4:
                   
                	int posicao = 0;
                	boolean informouPosicao = false;
                	
                	do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira a posicao do elemento na lista que deseja remover.");
                        if(elementoStr == null || elementoStr.isBlank()){
                            JOptionPane.showMessageDialog(null,"Favor informar uma posicao da lista");
                        } else {
                        	informouPosicao = true;
                        	posicao = Integer.parseInt(elementoStr);
                        }
                    } while(informouPosicao == false);
         
                    try {
                    	listaPontos.removePonto(posicao);
                    } catch (NaoFoiPossivelRemoverException | PosicaoInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                	
                    break;

                case 5:

                    try {
                        Double maiorDistancia = listaPontos.encontrarMaiorDistancia();
                        JOptionPane.showMessageDialog(null, "A maior distância entre dois pontos da coleção é: " + maiorDistancia);
                    } catch (QuantidadeInvalidaExceptions e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;
                case 6:
                    //Menu.pontosDentroDoCirculo(listaPontos, circulo)
                    break;
                case 7:
                    System.exit(0);
                    break;
            }

        } while (opcaoMenu != 7);
    }
}