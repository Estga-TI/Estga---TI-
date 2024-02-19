package Exercicio9;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        System.out.println("20 - Escala de (0 - 20)");
        System.out.println("10 - Escala de (0 - 10)");
        System.out.println("5 - Escala de (0 - 5)");

        System.out.print("Nota a converter: ");
        int nota = scan.nextInt();
        System.out.print("Escala da nota dada: ");
        int escala = scan.nextInt();
        System.out.print("Escala da nota a converter: ");
        int escalaconverter = scan.nextInt();



        int valor = (nota * escalaconverter) / escala;
        System.out.println("Nota convertida na escala " + escalaconverter + " foi " + valor);

    }
}
