package Exercicio12;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner ler = new Scanner( System.in );
        System.out.print("Introduza uma frase: ");
        String frase = ler.nextLine();

        frase = frase.toUpperCase();
        System.out.println("Frase convertida: " + frase);


        List<Integer> listOfIntegers = frase.chars()
                .boxed()
                .collect(Collectors.toList());

        for(int i:listOfIntegers) {
            System.out.println("ASCII valor "+ i);
        }

    }
}
