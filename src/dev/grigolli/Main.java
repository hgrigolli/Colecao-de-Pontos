package dev.grigolli;

import dev.grigolli.colecao.Circulo;
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
        ListaPontos listaPontos = new ListaPontos(10); // Talvez mudar para pedir ao usuario um numero de pontos

        do {
            do {

                opcaoMenuStr = JOptionPane.showInputDialog(
                        "Henrique Nobrega Grigolli - 41821661\n" +
                        "Kleber Takashi Yoshida - 41843533\n\n" +
                        "========MENU DE OPCOES========\n\n" +
                        "1. Adicionar um elemento no final da colecao\n" +
                        "2. Adicionar um elemento em uma posicao da colecao\n" +
                        "3. Retornar o indice da primeira ocorrencia de um elemento especificado na colecao\n" +
                        "4. Remover um elemento em uma posicao na colecao\n" +
                        "5. Calcular a distancia dos dois pontos mais distantes na colecao\n" +
                        "6. Retornar uma colecao de pontos contido em um circulo\n" +
                        "7. Sair do programa\n\n" +
                        "Colecao atual: " + listaPontos.toString() + "\n" +
                        "Colecao possui " + listaPontos.getValidos() + " elementos de " + listaPontos.getPontos().length + "\n\n");

                if(opcaoMenuStr == null || opcaoMenuStr.isBlank()){
                    opcaoMenu = null;
                    JOptionPane.showMessageDialog(null,"Favor escolher uma opcao.");
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
                                "Defina o ponto (x,y) e a posicao a ser inserida", null,
                                "X: ", x,
                                "Y: ", y,
                                "Posicao: ", posicao
                        };

                        int option = JOptionPane.showConfirmDialog(null, ponto, "Defina o ponto (x,y) e a posicao a ser inserida", JOptionPane.OK_CANCEL_OPTION);


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
                	
                	boolean achou = false; //flag para verificar se achou o ponto
                	
                	//criando a chamada no menu para pesquisar um ponto na lista, a partir do input do usuario
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

                	//percorre a lista de pontos e compara com os valores do input do usuario
                	int posicaoPonto = listaPontos.encontraPontoNaLista(elemento);
                	
                	if (posicaoPonto >= 0) {
                    	String mensagem = "Encontrado na posicao " + posicaoPonto + " da lista.";
                		JOptionPane.showMessageDialog(null, mensagem);
                    } else {
                    	String mensagemNaoEncontrado = "Ponto nao se encontra na lista ";
                		JOptionPane.showMessageDialog(null, mensagemNaoEncontrado); 
                    }

                    break;

                case 4:
                   
                	int posicao = 0;
                	boolean informouPosicao = false; 
                	
                	//criando a chamada no menu para o usuario informar o indice do elemento que deseja excluir
                	do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira a posicao do elemento na lista que deseja remover.");
                        if(elementoStr == null || elementoStr.isBlank()){
                            JOptionPane.showMessageDialog(null,"Favor informar uma posicao da lista");
                        } else {
                        	informouPosicao = true;
                        	posicao = Integer.parseInt(elementoStr);
                        }
                    } while(informouPosicao == false);
                	
                	//chamada do metodo que exclui o elemento da lista de pontos
                    try {
                    	listaPontos.removePonto(posicao);
                    } catch (NaoFoiPossivelRemoverException | PosicaoInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                	
                    break;

                case 5:

                    try {
                        Double maiorDistancia = listaPontos.encontrarMaiorDistancia();
                        JOptionPane.showMessageDialog(null, "A maior distancia entre dois pontos da colecao eh: " + maiorDistancia);
                    } catch (QuantidadeInvalidaExceptions e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;
                    
                case 6:
                	
                	Circulo circulo = new Circulo(elemento, 0.0); //objeto circulo para cada chamada do 'case 6', como default recebe todos os atributos iniciais como 0
                	
                	//criando a chamada no menu para criar o circulo a partir do input do usuario
                	do {
                    	JTextField x = new JTextField();
                        JTextField y = new JTextField();
                        JTextField raio = new JTextField();
                        
                        Object[] pontoDoCirculo = {
                                "Defina o ponto (x,y) e o raio do circulo", null,
                                "X: ", x,
                                "Y: ", y,
                                "Raio: ", raio,
                        };
                    	
                        int option = JOptionPane.showConfirmDialog(null, pontoDoCirculo, "Defina o ponto (x,y) e o raio do circulo", JOptionPane.OK_CANCEL_OPTION);
                        
                        //verifica se os elementos foram preenchidos
                        if (option == JOptionPane.OK_OPTION) {
                            if(x.getText() != null && y.getText() !=null && raio.getText() !=null){
                                elemento = new Ponto(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
                            }
                            if (raio.getText() == null || Double.valueOf(raio.getText()).doubleValue() <= 0) {
                            	JOptionPane.showMessageDialog(null,"Valor do raio deve ser maior que 0."); //raio deve ser maior que 0
                            	break;
                            }
                            circulo = new Circulo(elemento, Double.valueOf(raio.getText()).doubleValue()); //atualiza os valores do objeto circulo
                        } else {
                            elemento = null;
                            break;
                        }
                    } while(elemento == null);
                	

                	try {
                        ListaPontos listaPontosCirculo  = circulo.pontosNoCirculo(listaPontos); //chama o metodo que retorna a lista de pontos dentro do circulo
                        if(listaPontosCirculo != null){
                            JOptionPane.showMessageDialog(null,"Os pontos DENTRO do circulo sao: " + listaPontosCirculo.toString());
                        }
                	} catch (NaoFoiPossivelIncluirException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                	}
                	
                	         	
                    break;
                    
                case 7:
                    System.exit(0);
                    break;
            }

        } while (opcaoMenu != 7);
    }
}