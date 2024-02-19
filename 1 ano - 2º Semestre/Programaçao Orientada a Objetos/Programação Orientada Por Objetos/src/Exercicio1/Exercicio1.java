package Exercicio1;
import java.util.Scanner;
import java.util.Random;

import static java.lang.System.*;

public class Exercicio1 {
    public static void main(String[] args) {

        //Gerar um numero aleatorio
        Math.random();
        int aleatorio = (int) (0 + Math.random() * (50 - 0 + 1));

        //Leitura do numero introduzido pelo utilizador
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduza um numero advinhar: ");
        int numero = scan.nextInt();

        //Numero de tentativas do utilizador
        int tentativas = 0;
        int erros = 0;

        while (numero != aleatorio) {  //Enquanto o utilizador nao acertar no numero aleatorio gerado, faz este ciclo
            System.out.print("Introduza outra tentativa: ");
            numero = scan.nextInt();

            //Caso utilizador digite "-1" e considerado desisitir
            if (numero == -1) {
                out.println("Desistiu do jogo!");
                out.println("O numero aleatorio gerado foi: " + aleatorio);
            } else {
                //Verificar se o numero introduzido e maior, menor ou igual
                if (numero < aleatorio) {
                    out.println("O numero e menor que o valor aleatorio gerado!");
                    erros = tentativas++;
                    out.println("Tentativas: " + tentativas);
                }
                if (numero > aleatorio) {
                    out.println("O numero e maior que o valor aleatorio gerado!");
                    erros = tentativas++;
                    out.println("Tentativas: " + tentativas);
                }
                if (numero == aleatorio) {
                    out.println("O numero e igual ao valor aleatorio gerado! Ganhou!");
                    erros = tentativas++;
                    out.println("Tentativas: " + tentativas);
                }
            }
        }
    }
}

