package dev.grigolli;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        String opcaoMenuStr;
        Integer opcaoMenu = 0;

        do {
            do {

                opcaoMenuStr = JOptionPane.showInputDialog("========MENU DE OPÇÕES========\n\n" +
                        "1. Adicionar um elemento no final da coleção\n" +
                        "2. Adicionar um elemento em uma posição da coleção\n" +
                        "3. Retornar o índice da primeira ocorrência de um elemento especificado na coleção\n" +
                        "4. Remover um elemento em uma posição na coleção\n" +
                        "5. Calcular a distância dos dois pontos mais distantes na coleção\n" +
                        "6. Retornar uma coleção de pontos contido em um círculo\n" +
                        "7. Sair do programa\n\n");


                if(opcaoMenuStr == null || opcaoMenuStr.isBlank()){
                    opcaoMenu = null;
                    JOptionPane.showMessageDialog(null,"Favor escolher uma opção.");
                } else {
                    opcaoMenu = Integer.parseInt(opcaoMenuStr);
                }
            } while(opcaoMenu == null);

            Integer elemento;
            switch(opcaoMenu) {
                case 1:

                    do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira o valor do elemento");
                        if(elementoStr == null || elementoStr.isBlank()){
                            elemento = null;
                            JOptionPane.showMessageDialog(null,"Favor inserir um valor para o elemento");
                        } else {
                            elemento = Integer.parseInt(elementoStr);
                        }
                    } while(elemento == null);
                    break;

                case 2:

                    do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira o valor do elemento");
                        if(elementoStr == null || elementoStr.isBlank()){
                            elemento = null;
                            JOptionPane.showMessageDialog(null,"Favor inserir um valor para o elemento");
                        } else {
                            elemento = Integer.parseInt(elementoStr);
                        }
                    } while(elemento == null);
                    break;

                case 3:

                    do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira o valor do elemento");
                        if(elementoStr == null || elementoStr.isBlank()){
                            elemento = null;
                            JOptionPane.showMessageDialog(null,"Favor inserir um valor para o elemento");
                        } else {
                            elemento = Integer.parseInt(elementoStr);
                        }
                    } while(elemento == null);
                    break;

                case 4:
                   do {
                        String elementoStr = JOptionPane.showInputDialog(null, "Insira o valor do elemento");
                        if(elementoStr == null || elementoStr.isBlank()){
                            elemento = null;
                            JOptionPane.showMessageDialog(null,"Favor inserir um valor para o elemento");
                        } else {
                            elemento = Integer.parseInt(elementoStr);
                        }
                    } while(elemento == null);
                    break;

                case 5:
                    System.exit(0);
                    break;
                case 6:
                    System.exit(0);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }

        } while (opcaoMenu != 7);
    }
}