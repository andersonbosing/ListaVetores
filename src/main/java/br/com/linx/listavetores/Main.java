/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.listavetores;

import java.util.Scanner;

/**
 *
 * @author Anderson
 */
public class Main {

    private static final String msgInicial = "Digite um número um valor múltiplo"
            + " de 10 entre o intevalo de 100 e 1000:";

    private static final String msgSoma = "Deseja saber a soma dos valores "
            + "das posições pares ou Impares?(par/impar)";
    
    private static final String msgResultado = "Resultado da Soma dos Números "
            + "%s é: %s";
    
    private static final String msgErroParImpar = "Informe um Opção Válida!"
            + "(par/impar)";
    
    private static final String msgErro = "Informe um Opção Válida!";


    public static void main(String[] args) {

        double[] array = new double[10];
        
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println(msgInicial);
            int valueUser = 0;
            
            while (sc.hasNext()) {
                valueUser = sc.nextInt();
                
                if ((valueUser %10 == 0) && ((valueUser >= 100) && (valueUser <= 1000)))
                    break;
                else
                    System.out.println(msgErro + msgInicial);
            } 


            for (int i = 0; i < array.length; i++) {

                if (i % 3 == 0) {
                    //Multiplos de 3
                    //Índice da Posição x 30% x Valor Informado pelo Usuário
                    array[i] = i * (0.3 * valueUser);

                } else {
                    //Índice da Posição x 10% x Valor informado pelo Usuário
                    array[i] = i * (0.1 * valueUser);
                }

            }

            System.out.println(msgSoma);
            String somaPares = "";
            
            while (sc.hasNext()) {
                somaPares = sc.next().toLowerCase();
                if (somaPares.equals("par") || somaPares.equals("impar"))
                    break;
                else
                    System.out.println(msgErroParImpar + msgSoma);
            } 

            double posicoesSomadas = 0;
            int indice;

            if (somaPares.equals("par")) {
                indice = 0;
            } else {
                indice = 1;
            }

            for (indice = indice; indice < array.length; indice += 2) {
                posicoesSomadas = posicoesSomadas + array[indice];
            }
            
            System.out.println(String.format(msgResultado, somaPares.toUpperCase(), posicoesSomadas));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
