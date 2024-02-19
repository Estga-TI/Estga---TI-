package Exercicio10;
import java.util.Scanner;

public class Exercicio10 {
        public static void main(String[] args) {
            Scanner scan = new Scanner( System.in );
            System.out.print("Primeiro valor: ");
            int valor1 = scan.nextInt();
            System.out.print("Primeiro valor: ");
            int valor2 = scan.nextInt();


            int a = ( valor1 + valor2) / 2;
            int b = ( valor1 - valor2) / 2;

            int sum = a + b;
            int sub = a - b;
            System.out.println(a + " + " + b + " = " + sum);
            System.out.println(a + " - " + b + " = " + sub);
        }
}
