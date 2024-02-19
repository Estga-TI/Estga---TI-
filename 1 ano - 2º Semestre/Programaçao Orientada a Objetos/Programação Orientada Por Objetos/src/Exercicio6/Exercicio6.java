package Exercicio6;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.print("Introduza uma nota: "); //Pede ao utilizador uma nota para verificar
        int nota = scan.nextInt();

        //Abaixo estão as condições para atribuição das notas, segundo o número introduzido

        if (nota >= 0 && nota <= 100) {
            if (nota < 30) {
                System.out.println("A sua nota é um F"); //Imprime a nota F na tela
            }

            if (nota >= 30 && nota < 45){
                System.out.println("A sua nota é um E"); //Imprime a nota E na tela
            }

            if (nota >= 45 && nota < 60){
                System.out.println("A sua nota é um D"); //Imprime a nota D na tela
            }

            if (nota >= 60 && nota < 75){
                System.out.println("A sua nota é um C"); //Imprime a nota C na tela
            }

            if (nota >= 75 && nota < 90){
                System.out.println("A sua nota é um B"); //Imprime a nota B na tela
            }

            if (nota >= 90){
                System.out.println("A sua nota é um A"); //Imprime a nota A na tela
            }
        } else {
            System.out.println("Introduza um valor entre 0 e 100!");
        }
    }
}