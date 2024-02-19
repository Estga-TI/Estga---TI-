package Exercicio11;
import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        System.out.print("Velocidade do vento (v): ");
        int v = scan.nextInt();
        System.out.print("Valor da precipitação (p): ");
        int p = scan.nextInt();
        System.out.print("Temperatura máxima (tmax): ");
        int tmax = scan.nextInt();
        System.out.print("Valor da temperatura mínima (tmin): ");
        int tmin = scan.nextInt();
        System.out.print("Valor da altura (a) das ondas: ");
        int a = scan.nextInt();

        if (v >= 70 && v <= 90) {
            System.out.println("Aviso Amarelo (vento): " + v);
        } else if (v >= 91 && v <= 130) {
            System.out.println("Aviso Laranja (vento): " + v);
        } else if (v >130){
            System.out.println("Aviso Vermelho (vento): " + v);
        } else {
            System.out.println("Sem Qualquer aviso!");
        }

        if (p >= 10 && p <= 20) {
            System.out.println("Aviso Amarelo (precipitação): " + v);
        } else if (p >= 21 && p <= 40) {
            System.out.println("Aviso Laranja (precipitação): " + v);
        } else if (p > 40) {
            System.out.println("Aviso Vermelho (precipitação): " + v);
        } else {
            System.out.println("Sem Qualquer aviso!");
        }

        if (tmax >= 32 && tmax <= 36) {
            System.out.println("Aviso Amarelo (tmax): " + v);
        } else if (tmax >= 37 && tmax <= 38) {
            System.out.println("Aviso Laranja (tmax): " + v);
        } else if (tmax > 38) {
            System.out.println("Aviso Vermelho (tmax): " + v);
        } else {
            System.out.println("Sem Qualquer aviso!");
        }

        if (tmin >= -1 && tmin <= 1) {
            System.out.println("Aviso Amarelo (tmin): " + v);
        } else if (tmin >= -3 && tmin <= -2) {
            System.out.println("Aviso Laranja (tmin): " + v);
        } else if (tmin < -3) {
            System.out.println("Aviso Vermelho (tmin): " + v);
        } else {
            System.out.println("Sem Qualquer aviso!");
        }

        if (a >= 4 && a <= 5) {
            System.out.println("Aviso Amarelo (altura das ondas): " + v);
        } else if (a >= 6 && a <= 7) {
            System.out.println("Aviso Laranja (altura das ondas): " + v);
        } else if (a > 7) {
            System.out.println("Aviso Vermelho (altura das ondas): " + v);
        } else {
            System.out.println("Sem Qualquer aviso!");
        }

    }
}
