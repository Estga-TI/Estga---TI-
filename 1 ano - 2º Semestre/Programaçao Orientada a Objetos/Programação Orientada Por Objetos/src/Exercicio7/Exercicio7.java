package Exercicio7;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int numero;
        System.out.print("Introduza o número de valores a comparar: ");
        numero = scan.nextInt();
        int valor[] = new int[numero];
        int maior = 0, menor = 0;

        for(int i=0; i<valor.length; i++)
        {
            System.out.print("Digite o " +(i+1)+"º valor: ");
            valor[i] = scan.nextInt();
            if(valor[i] > maior){
                maior = valor[i];
            }
        }
        for (int j=0; j<valor.length; j++)
        {
            if(valor[j] < menor){
                menor = valor[j];
            }
        }
        System.out.println("Maior valor é "+ maior);
        System.out.println("Menor valor é "+ menor);
    }
}
