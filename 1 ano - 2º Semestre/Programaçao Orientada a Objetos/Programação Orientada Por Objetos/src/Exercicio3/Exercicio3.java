package Exercicio3;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args)
    {
        double numero;
        Scanner scan = new Scanner( System.in );
        System.out.print("Introduza um double: ");
        numero = scan.nextDouble();

        // Converte para inteiro
        int inteiro = (int)numero;
        // Imprime o valor em Inteiro
        System.out.println("Inteiro: " + inteiro);


        // Converte para byte
        byte by = (byte) numero;
        // Imprime o resultado
        System.out.println("Byte: "+ by);
    }
}
