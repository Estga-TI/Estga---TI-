package Exercicio8;
import java.util.Random;

public class Exercicio8 {
    public static void main(String[] args) {

        Random rand = new Random();
        int n = rand.nextInt(100); //Gera um valor random entre 0 e 100
        n += 1;
        System.out.println("O número aleatório gerado foi: " + n); //Imprime na tela o número random

        for (int i = 0; i < 25; i++) {  //Gera 25 valores aleatórios entre 0 e 100
            int r = rand.nextInt(100);
            if (r < n) {
                System.out.println(r + " menor");
            } else if (r > n) {
                System.out.println(r + " maior");
            } else {
                System.out.println(r + " e igual");
            }
        }
    }
}
